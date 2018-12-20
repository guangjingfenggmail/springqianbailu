package com.open.springqianbailu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.dao.UserMapper;
import com.open.springqianbailu.model.User;
import com.open.springqianbailu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Service(interfaceClass = UserService.class) //dubbo的service，注入接口
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User userByUserNamePwd(HashMap<String, Object> reqMap) {
        User user = userMapper.selectByUserNamePwd(reqMap);
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
        return userMapper.selectAll();
    }
}
