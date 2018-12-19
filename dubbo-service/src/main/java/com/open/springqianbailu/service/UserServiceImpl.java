package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.UserMapper;
import com.open.springqianbailu.interfaces.UserService;
import com.open.springqianbailu.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;


@Service
public class UserServiceImpl extends AbsServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User userByUserNamePwd(HashMap<String, Object> reqMap) {
        User  user = userMapper.selectByUserNamePwd(reqMap);
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

}
