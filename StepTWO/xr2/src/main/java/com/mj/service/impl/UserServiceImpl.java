package com.mj.service.impl;

import com.mj.bean.User;
import com.mj.bean.result.UserPageResult;
import com.mj.dao.UserDao;
import com.mj.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, UserPageResult> implements UserService {
    @Override
    public User find(User user) {
        return ((UserDao) dao).find(user);
    }
}
