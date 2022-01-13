package programmer.lp.learn.service.impl;

import org.springframework.stereotype.Component;
import programmer.lp.learn.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void test1() {
        System.out.println("UserServiceImpl-test1");
    }

    @Override
    public void test2() {
        System.out.println("UserServiceImpl-test2");
    }
}
