package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.UserMapper;
import com.open.springqianbailu.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_USER_OBJECT_KEY;

@Service("userService")
public class UserServiceImpl extends AbsServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User userByUserNamePwd(HashMap<String, Object> reqMap) {
        User user = (User) redisUtil.get(REDIS_USER_OBJECT_KEY + reqMap.toString());
        if (user == null) {
            user = userMapper.selectByUserNamePwd(reqMap);
            redisUtil.set(REDIS_USER_OBJECT_KEY + reqMap.toString(), user, REDIS_EXPIRE_TIME);
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

}
