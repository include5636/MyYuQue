package com.fjx.myYuQue.controller;

import javax.annotation.Resource;
// import javax.security.auth.Subject;

import com.fjx.myYuQue.dao.User;
import com.fjx.myYuQue.service.UserService;

// import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/loginCheck")
    public String login(User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(token);

        Subject subject = SecurityUtils.getSubject();
        try {
            System.out.println('!');
            subject.login(token);
            User user1 = (User) subject.getPrincipal();
            subject.getSession().setAttribute("user", user1);
            return "redirect:/index";
            // return "redirect:/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (UnauthorizedException e) {
            model.addAttribute("msg", "您没有权限!");
            return "login";
        }
    }

    @GetMapping("/noauth")
    public String noauth() {
        return "noauth";
    }

    // @RequestMapping("/loginCheck")
    // public String login(@RequestParam("username") String username,
    // @RequestParam("password") String password) {

    // User user = userService.getUser(username);
    // System.out.println(user);
    // if(user.toString().contains(password)) {
    // return "index";
    // } else {
    // return "loginError";
    // }
    // }
}
