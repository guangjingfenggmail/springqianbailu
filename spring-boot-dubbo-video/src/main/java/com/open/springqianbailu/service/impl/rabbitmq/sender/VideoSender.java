package com.open.springqianbailu.service.impl.rabbitmq.sender;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;
import com.open.springqianbailu.service.rabbitmq.RabbitQueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoSender {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Autowired
    private RabbitTemplate template;

    @Reference
    private RabbitQueueService rabbitQueueService;

    public void send(NovelMessage message) {
        Gson gson = new Gson();
        logger.info(TAG+" send========"+gson.toJson(message));
        CorrelationData correlationData = new CorrelationData(message.uuid);
        logger.info(TAG+" callbackSender UUID: " + correlationData.getId());
        template.convertAndSend(message.routingKey ,message,correlationData);

        RabbitQueue msg = new RabbitQueue();
        msg.setStatus(1);
        msg.setUuid(message.uuid);
        msg.setRabbit_mq_id(message.id);
        msg.setRoutingKey(message.routingKey);
        rabbitQueueService.insert(msg);
    }



}
