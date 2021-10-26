package com.mj.dao.impl;

import com.mj.bean.User;
import com.mj.bean.result.UserPageResult;
import com.mj.dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User, UserPageResult>
        implements UserDao {
    @Override
    public User find(User user) {
        try {
            String sql = "SELECT * FROM user WHERE email = ? and password = ?";
            return tpl.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    user.getEmail(), user.getPassword());
        } catch (DataAccessException e) {
            return null;
        }
    }
}
