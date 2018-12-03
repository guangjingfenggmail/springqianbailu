package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.User;
import com.open.springqianbailu.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

//    @RequestMapping("/showUser")
//    @ResponseBody
//    public User toIndex(HttpServletRequest request, Model model){
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.getUserById(userId);
//        return user;
//    }

    @ApiOperation(value = "getUserById", notes = "根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserById(@PathVariable String id){
        int userId = Integer.parseInt(id);
        User user = this.userService.getUserById(userId);
        if (user==null)
            return Result.error(0,"用户未注册");
        return Result.success(user);
    }


    @ApiOperation(value = "getUserByUserNamePwd", notes = "根据userName和pwd来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户userName", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "password", value = "用户password", required = true, dataType = "String", paramType = "path")
    })
    @RequestMapping(value = "/getUserByUserNamePwd/{userName}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserByUserNamePwd(@PathVariable String userName,@PathVariable String password){
        User user = this.userService.getUserByUserNamePwd(userName,password);
        if (user==null)
            return Result.error(0,"用户未注册");
        return Result.success(user);
    }


    @ApiOperation(value = "getUserByUserNamePwd", notes = "根据userName和pwd来获取用户详细信息")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value="/userByUserNamePwd", method=RequestMethod.POST)
    @ResponseBody
    public Result userByUserNamePwd(@RequestBody HashMap<String,Object> reqMap){
        User user = this.userService.userByUserNamePwd(reqMap);
        if (user==null)
            return Result.error(0,"用户未注册");
        return Result.success(user);
    }

}