package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import programmer.lp.jk.common.enhance.MPLambdaQueryWrapper;
import programmer.lp.jk.common.enhance.MPPage;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.common.util.Streams;
import programmer.lp.jk.mapper.SysResourceMapper;
import programmer.lp.jk.mapper.SysRoleResourceMapper;
import programmer.lp.jk.pojo.po.SysResource;
import programmer.lp.jk.pojo.po.SysRoleResource;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysResource;
import programmer.lp.jk.pojo.vo.resp.RespSysResource;
import programmer.lp.jk.pojo.vo.resp.RespSysResourceTree;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.SysResourceService;

import java.util.*;

@Transactional
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource>
        implements SysResourceService {
    @Autowired
    private SysRoleResourceMapper roleResourceMapper;

    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespSysResource> list(ReqPageSysResource reqVo) {
        MPLambdaQueryWrapper<SysResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.like(reqVo.getKeyword(), SysResource::getName, SysResource::getUri, SysResource::getPermission);
        wrapper.orderByAsc(SysResource::getId);
        return baseMapper
                .selectPage(new MPPage<>(reqVo), wrapper)
                .buildResult(MapStruct.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RespSysResource> listAll() {
        MPLambdaQueryWrapper<SysResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.orderByAsc(SysResource::getSn);
        return Streams.map(baseMapper.selectList(wrapper), MapStruct.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RespSysResource> listParents() {
        MPLambdaQueryWrapper<SysResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.ne(SysResource::getType, Constants.SysResourceType.BTN);
        wrapper.orderByAsc(SysResource::getType).orderByDesc(SysResource::getId);
        return Streams.map(baseMapper.selectList(wrapper), MapStruct.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RespSysResourceTree> listTree() {
        // 里面存放的是树状结构的VO（最外层是目录类型的资源对象）
        List<RespSysResourceTree> vos = new ArrayList<>();

        // 存放已经从po转换成功的vo
        Map<Short, RespSysResourceTree> doneVos = new HashMap<>();

        MPLambdaQueryWrapper<SysResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.orderByAsc(SysResource::getType); // 保证遍历顺序：目录、菜单、按钮
        // 里面存放的是从数据库中查出来的PO
        List<SysResource> pos = baseMapper.selectList(wrapper);
        for (SysResource po : pos) {
            // po转vo
            RespSysResourceTree vo = po2treeVo(po);

            Short type = po.getType();
            // 将vo存放到doneVos中
//            if (type == Constants.SysResourceType.DIR ||
//                    type == Constants.SysResourceType.MENU) {
                doneVos.put(vo.getId(), vo);
//            }

            if (type == Constants.SysResourceType.DIR) { // 目录
                vos.add(vo);
            } else { // 菜单、按钮
                // 从doneVos中取出父VO
                RespSysResourceTree parentVo = doneVos.get(po.getParentId());
                List<RespSysResourceTree> children = parentVo.getChildren();
                if (children == null) {
                    parentVo.setChildren(children = new ArrayList<>());
                }
                children.add(vo);
            }
        }
        return vos;
    }

    private RespSysResourceTree po2treeVo(SysResource po) {
        RespSysResourceTree treeVo = new RespSysResourceTree();
        treeVo.setId(po.getId());
        treeVo.setTitle(po.getName());
        return treeVo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Short> listIds(Integer roleId) {
        if (roleId == null || roleId <= 0) return null;

        MPLambdaQueryWrapper<SysRoleResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.select(SysRoleResource::getResourceId);
        wrapper.eq(SysRoleResource::getRoleId, roleId);

        List<Object> ids = roleResourceMapper.selectObjs(wrapper);
        return Streams.map(ids, (id) -> ((Integer) id).shortValue());
    }

    private List<Short> listIds(List<Short> roleIds) {
        MPLambdaQueryWrapper<SysRoleResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.select(SysRoleResource::getResourceId);
        wrapper.in(SysRoleResource::getRoleId, roleIds);
        List<Object> ids = roleResourceMapper.selectObjs(wrapper);
        return Streams.map(new HashSet<>(ids), (id) -> ((Integer) id).shortValue());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysResource> listByRoleIds(List<Short> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) return null;

        List<Short> ids = listIds(roleIds);
        if (CollectionUtils.isEmpty(ids)) return null;

        MPLambdaQueryWrapper<SysResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.in(SysResource::getId, ids);
        return baseMapper.selectList(wrapper);
    }
}
