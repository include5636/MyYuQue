package com.fjx.myYuQue.controller;

import javax.annotation.Resource;

import com.fjx.myYuQue.dao.User;
import com.fjx.myYuQue.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Resource
    private UserService userService;
    
    @RequestMapping("/loginCheck")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.getUser(username);
        System.out.println(user);
        if(user.toString().contains(password)) {
            return "index";
        } else {
            return "loginError";
        }
    }
}
