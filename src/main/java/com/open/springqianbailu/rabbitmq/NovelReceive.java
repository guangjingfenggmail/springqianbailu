package com.open.springqianbailu.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NovelReceive {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @RabbitListener(queues = RabbitMQConfig.QUEUENAME)    //监听器监听指定的Queue
    public void processC(String str) {
        logger.info("Receive:" + str);
    }
}
