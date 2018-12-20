package com.jaycekon.dubbo.controller;

import com.jaycekon.dubbo.domain.User;
import com.jaycekon.dubbo.service.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaycekon on 2017/9/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CityDubboConsumerService service;


    @RequestMapping("/save")
    public User saveUser() {

        return service.saveUser();
    }
}
