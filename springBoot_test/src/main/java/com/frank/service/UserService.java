package com.frank.service;

import com.frank.dao.UserMapper;
import com.frank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
