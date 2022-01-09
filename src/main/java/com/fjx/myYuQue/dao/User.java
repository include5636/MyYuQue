package com.fjx.myYuQue.dao;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String perms;
    private String role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
