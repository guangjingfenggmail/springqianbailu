package com.open.springqianbailu.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public final static String QUEUENAME_NOVEL = "queue-novel";
    public final static String QUEUENAME_GALLERY = "queue-gallery";

    @Bean
    Queue queue() {
        return new Queue(QUEUENAME_NOVEL, false);
    }

    @Bean
    Queue queueg() {
        return new Queue(QUEUENAME_GALLERY, false);
    }


}
