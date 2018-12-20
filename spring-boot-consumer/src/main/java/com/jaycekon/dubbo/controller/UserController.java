package com.jaycekon.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jaycekon.dubbo.domain.User;
import com.jaycekon.dubbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jaycekon on 2017/9/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    static final String masterUrl = "dubbo://127.0.0.1:20880";

    @Reference(url = masterUrl)
    UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public Object saveUser() {
        User user = new User();
        user.setUsername("jaycekon");
        user.setPassword("jaycekong824");
        userService.inserUser(user.getUsername(), user.getPassword());
        return user;
    }
}
