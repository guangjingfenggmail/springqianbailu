package com.jaycekon.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jaycekon.dubbo.domain.User;
import com.jaycekon.dubbo.mapper.UserMapper;
import com.jaycekon.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Jaycekon on 2017/9/19.
 */
@Component
@Service(interfaceClass = UserService.class) //dubbo的service，注入接口
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void inserUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insert(user);
    }

    @Override
    public User selectUser(int id) {
        return userMapper.select(id);
    }
}
