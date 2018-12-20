package com.jaycekon.dubbo.mapper;


import com.jaycekon.dubbo.domain.User;

/**
 * @author
 * @date 2018/11/21
 */
public interface UserMapper {

    void insert(User user);

    User select(int id);
}
