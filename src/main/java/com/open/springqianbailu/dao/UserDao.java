package com.open.springqianbailu.dao;

import com.open.springqianbailu.model.User;
import org.springframework.stereotype.Component;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}