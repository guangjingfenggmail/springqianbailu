package com.jaycekon.dubbo.service;

import com.jaycekon.dubbo.domain.User;

/**
 * Created by Jaycekon on 2017/9/19.
 */
public interface UserService {

      void inserUser(String username, String password);

      User selectUser(int id);
}
