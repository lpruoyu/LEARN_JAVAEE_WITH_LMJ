package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import programmer.lp.jk.common.cache.Caches;
import programmer.lp.jk.common.enhance.MPLambdaQueryWrapper;
import programmer.lp.jk.common.enhance.MPPage;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Streams;
import programmer.lp.jk.common.util.Strings;
import programmer.lp.jk.mapper.SysRoleMapper;
import programmer.lp.jk.mapper.SysUserRoleMapper;
import programmer.lp.jk.pojo.po.SysRole;
import programmer.lp.jk.pojo.po.SysRoleResource;
import programmer.lp.jk.pojo.po.SysUserRole;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysRole;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysRole;
import programmer.lp.jk.pojo.vo.resp.RespSysRole;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.SysRoleResourceService;
import programmer.lp.jk.service.SysRoleService;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Autowired
    private SysRoleResourceService roleResourceService;

    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespSysRole> list(ReqPageSysRole reqPage) {
        MPLambdaQueryWrapper<SysRole> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.like(reqPage.getKeyword(), SysRole::getName);
        wrapper.orderByDesc(SysRole::getId);
        return baseMapper.selectPage(new MPPage<>(reqPage), wrapper)
                .buildResult(MapStruct.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Short> listIds(Integer userId) {
        if (userId == null || userId <= 0) return null;
        MPLambdaQueryWrapper<SysUserRole> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.select(SysUserRole::getRoleId);
        wrapper.eq(SysUserRole::getUserId, userId);
        return Streams.map(userRoleMapper.selectObjs(wrapper), (id) -> ((Integer) id).shortValue());
    }

    @Override
    public boolean saveOrUpdate(ReqSaveSysRole entity) {
        // 转成PO
        SysRole po = MapStruct.INSTANCE.vo2po(entity);

        // 保存角色信息
        if (!saveOrUpdate(po)) return false;

        Short id = entity.getId();
        if (id != null && id > 0) {
            MPLambdaQueryWrapper<SysUserRole> wrapper = new MPLambdaQueryWrapper<>();
            wrapper.select(SysUserRole::getUserId);
            wrapper.eq(SysUserRole::getRoleId, id);
            List<Object> userIds = userRoleMapper.selectObjs(wrapper);
            if (!CollectionUtils.isEmpty(userIds)) {
                for (Object userId : userIds) {
                    // 将拥有这个角色的用户从缓存中移除（让token失效，用户必须重新登录）
                    Caches.removeToken(Caches.get(userId));
                }
            }

            // 删除当前角色的所有资源信息
            roleResourceService.removeByRoleId(id);
        }

        // 保存角色信息
        String resourceIdsStr = entity.getResourceIds();
        if (Strings.isEmpty(resourceIdsStr)) return true;

        String[] resourceIds = resourceIdsStr.split(",");
        List<SysRoleResource> roleResources = new ArrayList<>();
        Short roleId = po.getId();
        for (String resourceId : resourceIds) { // 构建SysUserRole对象
            SysRoleResource roleResource = new SysRoleResource();
            roleResource.setRoleId(roleId);
            roleResource.setResourceId(Short.parseShort(resourceId));
            roleResources.add(roleResource);
        }
        return roleResourceService.saveBatch(roleResources);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysRole> listByUserId(Integer userId) {
        if (userId == null || userId <= 0) return null;
        List<Short> ids = listIds(userId);
        if (CollectionUtils.isEmpty(ids)) return null;

        MPLambdaQueryWrapper<SysRole> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.in(SysRole::getId, ids);

//        String sql = "SELECT role_id FROM sys_user_role WHERE user_id = " + userId;
//        wrapper.inSql(SysRole::getId, sql);

        return baseMapper.selectList(wrapper);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysRole> list() {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(SysRole::getId);
        return super.list(wrapper);
    }
}
