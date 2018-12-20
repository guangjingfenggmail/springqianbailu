package com.open.springqianbailu.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public final static String QUEUENAME_APPINFO = "queue-appinfo";


    @Bean
    Queue queue() {
        return new Queue(QUEUENAME_APPINFO, false);
    }

}
