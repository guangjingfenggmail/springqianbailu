package com.open.springqianbailu.controller;

import com.open.springqianbailu.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class AbsController {
    public  String TAG = getClass().getSimpleName();
    public  Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    public RedisUtil redisUtil;
}
