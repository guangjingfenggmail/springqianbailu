package com.open.springqianbailu.service;
import com.open.springqianbailu.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
    public User getUserById(int userId);

    public User getUserByUserNamePwd(String userName, String password);

    public boolean addUser(User record);


    public User userByUserNamePwd(HashMap<String,Object> reqMap);

}