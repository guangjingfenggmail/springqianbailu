package com.jaycekon.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jaycekon.dubbo.domain.User;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 * <p>
 * Created by Jaycekon on 20/09/2017.
 */
@Component
public class CityDubboConsumerService {


    @Reference
    UserService userService;

    public User saveUser() {
        User user = new User();
        user.setUsername("jaycekon");
        user.setPassword("jaycekong824");
        return userService.saveUser(user);
    }
}
