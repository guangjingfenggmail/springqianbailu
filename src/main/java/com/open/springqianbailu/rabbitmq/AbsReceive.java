package com.open.springqianbailu.rabbitmq;

import com.open.springqianbailu.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class AbsReceive {

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    public RedisUtil redisUtil;

    @Autowired
    public RestTemplate restTemplate;
}
