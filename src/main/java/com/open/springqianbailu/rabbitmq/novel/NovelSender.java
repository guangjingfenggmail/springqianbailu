package com.open.springqianbailu.rabbitmq.novel;


import com.google.gson.Gson;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
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

    public void send(NovelMessage message) {
        Gson gson = new Gson();
        logger.info(TAG,"send========"+gson.toJson(message));
        template.convertAndSend(RabbitMQConfig.QUEUENAME ,message);
    }

}
