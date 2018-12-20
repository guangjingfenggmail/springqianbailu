package com.jaycekon.mybatis.multi.controller;

import com.jaycekon.mybatis.multi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangweijie
 * @date 2018/11/22
 */
@RestController
@RequestMapping("/user")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test() {
        userService.inserUser("root1", "root1");
        return "hello";
    }
}
