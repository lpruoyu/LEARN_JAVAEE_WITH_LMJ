package programmer.lp.old.service.impl;

import programmer.lp.old.service.UserService;

public class UserServiceImpl implements UserService {

    // 核心业务
    @Override
    public boolean login(String username, String password) {
        // ...
        // dao等操作
        // ...
        System.out.println("UserService的核心业务");
        return "lpruoyu".equals(username) && "123456".equals(password);
    }

}