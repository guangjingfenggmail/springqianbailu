package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.User;
import com.open.springqianbailu.redis.RedisUtil;
import com.open.springqianbailu.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_USER_OBJECT_KEY;

@Controller
@RequestMapping(value = "/account")
public class UserController {
    static Logger logger = LoggerFactory.getLogger(UserController.class.getSimpleName());

    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;



    @ApiOperation(value = "login", notes = "根据userName和pwd来获取用户详细信息{\"userName\":\"root\",\"password\":\"123\"}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value="/login", method=RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody HashMap<String,Object> reqMap){
        User user = (User) redisUtil.get(REDIS_USER_OBJECT_KEY+reqMap.toString());
        if (user==null){
            user = this.userService.userByUserNamePwd(reqMap);
            redisUtil.set(REDIS_USER_OBJECT_KEY+reqMap.toString(),user);
        }
        if (user==null)
            return Result.error(0,"用户未注册");

        Gson gson = new Gson();
        logger.info("UserController"+gson.toJson(user));
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