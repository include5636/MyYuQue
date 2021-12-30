package com.fjx.myYuQue.service;

import com.fjx.myYuQue.dao.User;

public interface UserService {

    int addUser(User user);

    User getUser(String username);
}
