package programmer.lp.service.impl;

import programmer.lp.service.UserService;

public class UserServiceImpl implements UserService{

    @Override
    public boolean login(String username, String password) {
        System.out.println("---------UserServiceImpl-----------login--------------------");
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        System.out.println("----------UserServiceImpl----------register--------------------");
        return false;
    }

}