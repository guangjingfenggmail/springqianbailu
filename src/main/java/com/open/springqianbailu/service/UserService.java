package com.open.springqianbailu.service;
import com.open.springqianbailu.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);

}