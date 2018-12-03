package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.User;
import com.open.springqianbailu.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @ApiOperation(value = "showUser", notes = "根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/showUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result showUser(@PathVariable String id){
        int userId = Integer.parseInt(id);
        User user = this.userService.getUserById(userId);
        if (user==null)
            return Result.error(0,"用户未注册");
        return Result.success(user);
    }

}