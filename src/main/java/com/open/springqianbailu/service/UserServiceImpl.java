package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.UserMapper;
import com.open.springqianbailu.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User userByUserNamePwd(HashMap<String, Object> reqMap) {
        return userMapper.selectByUserNamePwd(reqMap);
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

}
