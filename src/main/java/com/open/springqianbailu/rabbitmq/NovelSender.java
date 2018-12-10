package com.open.springqianbailu.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NovelSender {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Autowired
    private AmqpTemplate template;

    public void send() {
        String uuid = UUID.randomUUID().toString();
        logger.info(TAG,"send========");
        template.convertAndSend(RabbitMQConfig.QUEUENAME ,"hello,rabbit~");
    }

}
