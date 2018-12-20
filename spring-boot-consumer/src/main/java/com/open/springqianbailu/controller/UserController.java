package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.User;
import com.open.springqianbailu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping(value = "/account")
public class UserController{
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Reference
    private UserService userService;

    @RequestMapping(value="/login", method=RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody HashMap<String,Object> reqMap){
        User user = this.userService.userByUserNamePwd(reqMap);
        if (user==null)
            return Result.error(0,"用户未注册");

        Gson gson = new Gson();
        logger.info(TAG+"==="+gson.toJson(user));
        return Result.success(user);
    }

    @RequestMapping(value="/allUsers")
    @ResponseBody
    public Result allUsers(){
        List<User> list = this.userService.selectAll();
        if (list==null)
            return Result.error(0,"用户未注册");

        Gson gson = new Gson();
        logger.info(TAG+"==="+gson.toJson(list));
        return Result.success(list);
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user){
        boolean result =  this.userService.addUser(user);
        return Result.success(result);
    }

}