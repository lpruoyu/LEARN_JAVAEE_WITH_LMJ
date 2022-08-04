package programmer.lp.jk.common.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import programmer.lp.jk.common.cache.Caches;
import programmer.lp.jk.pojo.dto.SysUserDto;
import programmer.lp.jk.pojo.po.SysResource;
import programmer.lp.jk.pojo.po.SysRole;
import programmer.lp.jk.service.SysResourceService;
import programmer.lp.jk.service.SysRoleService;

import java.util.List;

@Slf4j
public class TokenRealm extends AuthorizingRealm {
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysResourceService resourceService;

    public TokenRealm(TokenMatcher matcher) {
        super(matcher);
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        log.debug("TokenRealm - supports - {}", token);
        return token instanceof Token; // 只处理我们自己的Token
    }

    // 认证通过才会调用授权方法加载权限信息
    // AuthorizationInfo用来存放用户的权限信息的
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 拿到当前登录用户的token
        String token = (String) principals.getPrimaryPrincipal();
        log.debug("TokenRealm - doGetAuthorizationInfo - {}", token);

        // 根据token查找用户的角色、权限
        SysUserDto user = Caches.getToken(token);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<SysRole> roles = user.getRoles();
        if (CollectionUtils.isEmpty(roles)) return info;

        // 添加角色
        for (SysRole role : roles) {
            info.addRole(role.getName());
        }

        List<SysResource> resources = user.getResources();
        if (CollectionUtils.isEmpty(resources)) return info;
        // 添加权限
        for (SysResource resource : resources) {
            info.addStringPermission(resource.getPermission());
        }
        return info;

//        SysUser user = Caches.getToken(token);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        // 根据用户id查询所有的角色：sys_role，sys_user_role
//        List<SysRole> roles = roleService.listByUserId(user.getId());
//        if (CollectionUtils.isEmpty(roles)) return info;
//
//        // 添加角色
//        for (SysRole role : roles) {
//            info.addRole(role.getName());
//        }
//
//        // 根据角色id查询所有的资源：sys_resource、sys_role_resource
//        List<Short> roleIds = Streams.map(roles, SysRole::getId);
//        List<SysResource> resources = resourceService.listByRoleIds(roleIds);
//        if (CollectionUtils.isEmpty(resources)) return info;
//
//        // 添加权限
//        for (SysResource resource : resources) {
//            info.addStringPermission(resource.getPermission());
//        }
//        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String tk = ((Token) token).getToken();
        log.debug("TokenRealm - doGetAuthenticationInfo - {}", tk);
        return new SimpleAuthenticationInfo(tk, tk, getName());
    }
}