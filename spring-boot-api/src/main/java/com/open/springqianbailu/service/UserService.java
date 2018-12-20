package com.open.springqianbailu.service;

import com.open.springqianbailu.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    boolean addUser(User record);

    User userByUserNamePwd(HashMap<String, Object> reqMap);

    List<User> selectAll();
}