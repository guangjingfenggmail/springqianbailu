package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.User;
import com.open.springqianbailu.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/account")
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

//    @ApiOperation(value = "getUserById", notes = "根据id来获取用户详细信息")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
//    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Result getUserById(@PathVariable String id){
//        int userId = Integer.parseInt(id);
//        User user = this.userService.getUserById(userId);
//        if (user==null)
//            return Result.error(0,"用户未注册");
//        return Result.success(user);
//    }
//
//
//    @ApiOperation(value = "getUserByUserNamePwd", notes = "根据userName和pwd来获取用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userName", value = "用户userName", required = true, dataType = "String", paramType = "path"),
//            @ApiImplicitParam(name = "password", value = "用户password", required = true, dataType = "String", paramType = "path")
//    })
//    @RequestMapping(value = "/getUserByUserNamePwd/{userName}/{password}", method = RequestMethod.GET)
//    @ResponseBody
//    public Result getUserByUserNamePwd(@PathVariable String userName,@PathVariable String password){
//        User user = this.userService.getUserByUserNamePwd(userName,password);
//        if (user==null)
//            return Result.error(0,"用户未注册");
//        return Result.success(user);
//    }


    @ApiOperation(value = "login", notes = "根据userName和pwd来获取用户详细信息{\"userName\":\"root\",\"password\":\"123\"}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value="/login", method=RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody HashMap<String,Object> reqMap){
        User user = this.userService.userByUserNamePwd(reqMap);
        if (user==null)
            return Result.error(0,"用户未注册");
        return Result.success(user);
    }



    @ApiOperation(value = "register", notes = "注册{\"userName\":\"fgj\",\"password\":\"113\"}")
    @ApiImplicitParam(name = "user", value = "用户user", required = true,dataType = "User", paramType = "body")
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user){
        boolean result =  this.userService.addUser(user);
        return Result.success(result);
    }

}