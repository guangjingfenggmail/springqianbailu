package com.open.springqianbailu.dao;

import com.open.springqianbailu.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByUserNamePwd(HashMap map);

    List<User> selectAll();
}