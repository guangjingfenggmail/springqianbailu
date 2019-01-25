package com.open.springqianbailu.service.impl.rabbitmq;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.rabbitmq.RabbitMessageMapper;
import com.open.springqianbailu.model.table.rabbitmq.RabbitMessage;
import com.open.springqianbailu.service.rabbitmq.RabbitMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Component
@Service(interfaceClass = RabbitMessageService.class) //dubbo的service，注入接口
public class RabbitMessageServiceImpl implements RabbitMessageService {
    @Resource
    public RedisUtil redisUtil;

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Autowired
    private RabbitMessageMapper rabbitMessageMapper;

    @Override
    public int insert(RabbitMessage record) {
        return rabbitMessageMapper.insert(record);
    }

    @Override
    public List<RabbitMessage> selectAll() {
        return rabbitMessageMapper.selectAll();
    }

    @Override
    public List<RabbitMessage> selectById(HashMap map) {
        return rabbitMessageMapper.selectById(map);
    }

    @Override
    public List<RabbitMessage> selectByUUId(String uuid) {
        return rabbitMessageMapper.selectByUUId(uuid);
    }
}
