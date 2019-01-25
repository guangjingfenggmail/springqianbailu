package com.open.springqianbailu.service.impl.rabbitmq;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.rabbitmq.RabbitQueueMapper;
import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;
import com.open.springqianbailu.service.rabbitmq.RabbitQueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Service(interfaceClass = RabbitQueueService.class) //dubbo的service，注入接口
public class RabbitQueueServiceImpl implements RabbitQueueService {
    @Resource
    public RedisUtil redisUtil;

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    private RabbitQueueMapper rabbitQueueMapper;

    @Override
    public int insert(RabbitQueue record) {
        return rabbitQueueMapper.insert(record);
    }


    @Override
    public void updateById(RabbitQueue message) {
        rabbitQueueMapper.updateById(message);
    }


}
