package com.mj.dao;

import com.mj.bean.User;
import com.mj.bean.result.UserPageResult;

public interface UserDao extends BaseDao<User, UserPageResult> {
    User find(User user);
}
