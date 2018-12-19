package com.open.springqianbailu.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public final static String QUEUENAME_APPINFO = "queue-appinfo";

    public final static String QUEUENAME_VIEWTYPE_ITEM = "queue-view-type-item";

    @Bean
    Queue queue() {
        return new Queue(QUEUENAME_APPINFO, false);
    }

    @Bean
    Queue queue2() {
        return new Queue(QUEUENAME_VIEWTYPE_ITEM, false);
    }


}
