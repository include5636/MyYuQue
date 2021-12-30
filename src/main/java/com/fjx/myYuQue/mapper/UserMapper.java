package com.fjx.myYuQue.mapper;

import com.fjx.myYuQue.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int addUser(User user);

    User getUser(String username);

}
