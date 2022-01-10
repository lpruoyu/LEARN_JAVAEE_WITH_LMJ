package programmer.lp.service.impl;

import programmer.lp.annotation.Log;
import programmer.lp.service.UserService;

public class UserServiceImpl2 implements UserService {

    @Override
    @Log // 目标方法：需要代理
    public boolean login(String username, String password) {
        System.out.println("--------------------login--------------------");
        // 此处调用了另外一个目标方法
        if (register(username, password)) {
//        if (register(this.username, password)) {
//        if (register(username, password)) {
            return "lpruoyu".equals(username) && "123456".equals(password);
        }
        return false;
    }

    @Override
    @Log // 目标方法：需要代理
    public boolean register(String username, String password) {
        System.out.println("--------------------register--------------------");
        return username.equals(password);
    }

}