package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import programmer.lp.jk.common.cache.Caches;
import programmer.lp.jk.common.enhance.CodeMsg;
import programmer.lp.jk.common.enhance.MPLambdaQueryWrapper;
import programmer.lp.jk.common.enhance.MPPage;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.common.util.Streams;
import programmer.lp.jk.common.util.Strings;
import programmer.lp.jk.mapper.SysUserMapper;
import programmer.lp.jk.pojo.dto.SysUserDto;
import programmer.lp.jk.pojo.po.SysResource;
import programmer.lp.jk.pojo.po.SysRole;
import programmer.lp.jk.pojo.po.SysUser;
import programmer.lp.jk.pojo.po.SysUserRole;
import programmer.lp.jk.pojo.vo.req.ReqLogin;
import programmer.lp.jk.pojo.vo.req.page.ReqPageSysUser;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysUser;
import programmer.lp.jk.pojo.vo.resp.RespLogin;
import programmer.lp.jk.pojo.vo.resp.RespSysUser;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.SysResourceService;
import programmer.lp.jk.service.SysRoleService;
import programmer.lp.jk.service.SysUserRoleService;
import programmer.lp.jk.service.SysUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {
    @Autowired
    private SysUserRoleService userRoleService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysResourceService resourceService;

    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespSysUser> list(ReqPageSysUser reqPage) {
        MPLambdaQueryWrapper<SysUser> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.like(reqPage.getKeyword(), SysUser::getUsername, SysUser::getNickname);
        wrapper.orderByDesc(SysUser::getId);
        return baseMapper.selectPage(new MPPage<>(reqPage), wrapper)
                .buildResult(MapStruct.INSTANCE::po2vo);
    }

    @Override
    public boolean saveOrUpdate(ReqSaveSysUser entity) {
        // 转成PO
        SysUser po = MapStruct.INSTANCE.vo2po(entity);

        // 保存用户信息
        if (!saveOrUpdate(po)) return false;

        Integer id = entity.getId();
        if (id != null && id > 0) {// 如果是做更新
            // 将更新成功的用户从缓存中移除（让token失效，用户必须重新登录）
            Caches.removeToken(Caches.get(id));
//            Caches.remove(id);
            // 删除当前用户的所有角色信息
            userRoleService.removeByUserId(entity.getId());
        }

        // 保存角色信息
        String roleIdsStr = entity.getRoleIds();
        if (Strings.isEmpty(roleIdsStr)) return true;

        String[] roleIds = roleIdsStr.split(",");
        List<SysUserRole> userRoles = new ArrayList<>();
        Integer userId = po.getId();
        for (String roleId : roleIds) { // 构建SysUserRole对象
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(Short.parseShort(roleId));
            userRoles.add(userRole);
        }
        return userRoleService.saveBatch(userRoles);
    }

    @Override
    public RespLogin login(ReqLogin reqVo) {
        // 根据用户名查询用户
        MPLambdaQueryWrapper<SysUser> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, reqVo.getUsername());
        SysUser po = baseMapper.selectOne(wrapper);

        // 用户名不存在
        if (po == null) {
            return JSONResults.exception(CodeMsg.WRONG_USERNAME);
        }

        // 密码不正确
        if (!po.getPassword().equals(reqVo.getPassword())) {
            return JSONResults.exception(CodeMsg.WRONG_PASSWORD);
        }

        // 账号锁定
        if (po.getStatus() == Constants.SysUserStatus.LOCKED) {
            return JSONResults.exception(CodeMsg.USER_LOCKED);
        }

        /** 登录成功 **/

        // 更新登录时间
        po.setLoginTime(new Date());
        baseMapper.updateById(po);

        SysUserDto dto = new SysUserDto();
        dto.setUser(po);
        // 根据用户id查询所有的角色：sys_role，sys_user_role
        List<SysRole> roles = roleService.listByUserId(po.getId());

        // 根据角色id查询所有的资源：sys_resource、sys_role_resource
        if (!CollectionUtils.isEmpty(roles)) {
            dto.setRoles(roles);

            List<Short> roleIds = Streams.map(roles, SysRole::getId);
            List<SysResource> resources = resourceService.listByRoleIds(roleIds);
            dto.setResources(resources);
        }

        // 生成Token，发送Token给用户
        String token = UUID.randomUUID().toString();
        // 存储token到缓存中
        Caches.putToken(token, dto);
        // 以便将来通过用户ID找到他对应的Token
//        Caches.put(po.getId(), token);

        // 返回给客户端的具体数据
        RespLogin vo = MapStruct.INSTANCE.po2loginVo(po);
        vo.setToken(token);
        return vo;
    }
}
