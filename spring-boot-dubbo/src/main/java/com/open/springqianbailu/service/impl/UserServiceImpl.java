package com.open.springqianbailu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.UserMapper;
import com.open.springqianbailu.model.User;
import com.open.springqianbailu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;

@Component
@Service(interfaceClass = UserService.class) //dubbo的service，注入接口
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    public RedisUtil redisUtil;

    @Override
    public User userByUserNamePwd(HashMap<String, Object> reqMap) {
        User user = (User) redisUtil.get("UserService" + reqMap.toString());
        if (user==null){
            user = userMapper.selectByUserNamePwd(reqMap);
            redisUtil.set("UserService" + reqMap.toString(), user, REDIS_EXPIRE_TIME);
        }
        return user;
    }

    @Override
    public boolean addUser(User record) {
        boolean result = false;
        try {
            userMapper.insert(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<User> selectAll() {
        List<User> list = (List<User>) redisUtil.get("UserService"+"selectAll");
        if (list==null || list.size()==0){
            list = userMapper.selectAll();
            redisUtil.set("UserService" + "selectAll", list, REDIS_EXPIRE_TIME);
        }
        return list;
    }
}
