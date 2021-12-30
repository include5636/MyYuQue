package com.fjx.myYuQue.controller;

import javax.annotation.Resource;

import com.fjx.myYuQue.dao.User;
import com.fjx.myYuQue.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {

    @Resource
    private UserService userService;

    @RequestMapping("/registerCheck")
    public String register(@RequestParam("username") String usrname, @RequestParam("password") String pwd) {
        User user = new User(usrname, pwd);
        userService.addUser(user);
        // userService.addUser(usrname, pwd);
        return "login";
    }
}
