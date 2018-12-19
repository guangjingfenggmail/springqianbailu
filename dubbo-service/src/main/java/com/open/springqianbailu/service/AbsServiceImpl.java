package com.open.springqianbailu.service;

import com.open.springqianbailu.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class AbsServiceImpl {
    @Resource
    public RedisUtil redisUtil;
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

}
