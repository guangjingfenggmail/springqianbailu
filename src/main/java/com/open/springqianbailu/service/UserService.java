package com.open.springqianbailu.service;

import com.open.springqianbailu.model.User;

import java.util.HashMap;

public interface UserService extends AbsSevice{

    public boolean addUser(User record);

    public User userByUserNamePwd(HashMap<String,Object> reqMap);

}