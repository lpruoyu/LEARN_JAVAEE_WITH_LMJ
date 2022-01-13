package programmer.lp.old.service.impl;

import programmer.lp.old.service.UserService;

// 核心业务
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        // ...
        // dao等操作
        // ...
        System.out.println("UserService的核心业务-login");
        return "lpruoyu".equals(username) && "123456".equals(password);
    }
    @Override
    public boolean register(String username, String password, String pswdConfirm) {
        // ...
        // dao等操作
        // ...
        System.out.println("UserService的核心业务-register");
        return username != null && password != null && !"".equals(username) && password.equals(pswdConfirm);
    }

}