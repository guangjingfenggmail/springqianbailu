package com.open.springqianbailu.rabbitmq;

import com.google.gson.Gson;
import com.open.springqianbailu.model.rabbitmq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class HomeSender implements RabbitTemplate.ConfirmCallback {

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Autowired
    private RabbitTemplate template;


    public void send(Message message) {
        Gson gson = new Gson();
        logger.info(TAG+"send========");
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info(TAG+"callbackSender UUID: " + correlationData.getId());
        template.convertAndSend(RabbitMQConfig.QUEUENAME_APPINFO ,message,correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info(TAG+correlationData.getId());
    }
}