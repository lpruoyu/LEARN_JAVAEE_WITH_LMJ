package com.mj;

import java.util.List;

public class Dbs {
    public static SysUser get(String username) {
        if ("mj666".equals(username)) {
            SysUser user = new SysUser();
            user.setUsenrname("mj666");
            user.setPassword("mj666");
            return user;
        } else if ("mj333".equals(username)) {
            SysUser user = new SysUser();
            user.setUsenrname("mj333");
            user.setPassword("mj333");
            return user;
        }
        return null;
    }

    public static List<String> getRoles(String username) {
        if ("mj666".equals(username)) {
            return List.of("admin");
        } else if ("mj333".equals(username)) {
            return List.of("normal");
        }
        return null;
    }

    public static List<String> getPermissions(String username) {
        if ("mj666".equals(username)) {
            return List.of("user:create", "user:update", "user:delete");
        } else  if ("mj333".equals(username)) {
            return List.of("user:read");
        }
        return null;
    }
}
