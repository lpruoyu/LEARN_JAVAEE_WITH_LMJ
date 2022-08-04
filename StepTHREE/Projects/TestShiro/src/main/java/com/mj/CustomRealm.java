package com.mj;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    /**
     * 当主体（subject）要进行权限\角色判断时，就会调用
     *
     * 开发者需要在这个方法中干啥？【一般】
     * 根据用户名查询用户的角色\权限信息
     *
     * @return 用户的角色\权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<String> roles = Dbs.getRoles(username);
        if (roles != null) {
            info.addRoles(roles);
        }

        List<String> permissions = Dbs.getPermissions(username);
        if (permissions != null) {
            info.addStringPermissions(permissions);
        }

        return info;
    }

    /**
     * 当主体（subject）要进行认证时，就会调用
     *
     * 开发者需要在这个方法中干啥？【一般】
     * 根据用户名查询用户的具体信息（用户名、密码）
     *
     * @param token subject.login()登录时传进来的token
     * @return 用户名的具体信息（用户名、密码）
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取token
        UsernamePasswordToken tk = (UsernamePasswordToken) token;

        // 根据用户名去数据库中查询用户信息
        String username = (String) tk.getPrincipal();
        SysUser user = Dbs.get(username);
        if (user == null) return null;

        // 认证成功
        return new SimpleAuthenticationInfo(user.getUsenrname(), user.getPassword(), getName());
    }


    // 判断认证是否成功
//        if (user == null) {
//            throw new UnknownAccountException();
//        }

//        String password = tk.getCredentials().toString();
//        if (!password.equals(user.getPassword())) {
//            throw new IncorrectCredentialsException();
//        }
}
