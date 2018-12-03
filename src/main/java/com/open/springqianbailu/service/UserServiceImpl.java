package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.UserDao;
import com.open.springqianbailu.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByUserNamePwd(String userName, String password) {
        HashMap<String,String> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);

        return userDao.selectByUserNamePwd(map);
    }

    @Override
    public User userByUserNamePwd(HashMap<String, Object> reqMap) {
        return userDao.selectByUserNamePwd(reqMap);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
