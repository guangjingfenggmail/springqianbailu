package com.open.springqianbailu.rabbitmq.xiaomi;

import com.google.gson.Gson;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class HomeAppinfoSender implements RabbitTemplate.ConfirmCallback {

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Autowired
    private RabbitTemplate template;


    public void send(Message message) {
        Gson gson = new Gson();
        logger.info(TAG+"send========");
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info(TAG+"callbackSender UUID: " + correlationData.getId());
        template.convertAndSend(RabbitMQConfig.QUEUENAME ,message,correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info(TAG+correlationData.getId());
    }
}
