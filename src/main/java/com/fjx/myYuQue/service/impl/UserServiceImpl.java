package com.fjx.myYuQue.service.impl;

import javax.annotation.Resource;
import com.fjx.myYuQue.dao.User;
import com.fjx.myYuQue.mapper.UserMapper;
import com.fjx.myYuQue.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }

}
