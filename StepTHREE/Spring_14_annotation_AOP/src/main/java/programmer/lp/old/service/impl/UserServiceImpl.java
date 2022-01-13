package programmer.lp.old.service.impl;

import org.springframework.stereotype.Service;
import programmer.lp.old.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void test1() {
        System.out.println("UserServiceImpl test1");
    }
    @Override
    public void test2() {
        System.out.println("UserServiceImpl test2");
    }
}