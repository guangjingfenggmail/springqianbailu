package com.open.springqianbailu.rabbitmq.novel;


import com.google.gson.Gson;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.SubMenu;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
import com.open.springqianbailu.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class NovelSender implements RabbitTemplate.ConfirmCallback{
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Autowired
    private RabbitTemplate template;

    @Resource
    public RedisUtil redisUtil;

    public void send(NovelMessage message,SubMenu menu) {
        Gson gson = new Gson();
        logger.info(TAG,"send========"+gson.toJson(message));

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info(TAG,"callbackSender UUID: " + correlationData.getId());

        List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref(),Integer.parseInt(message.pageNo));
        redisUtil.set(message.submenuId+message.pageNo,list);
        template.convertAndSend(RabbitMQConfig.QUEUENAME ,message,correlationData);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info(TAG,correlationData.getId());
    }
}
