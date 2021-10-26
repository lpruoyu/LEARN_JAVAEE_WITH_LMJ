package com.mj.service;

import com.mj.bean.User;
import com.mj.bean.result.UserPageResult;

public interface UserService extends BaseService<User, UserPageResult> {
    User find(User user);
}
