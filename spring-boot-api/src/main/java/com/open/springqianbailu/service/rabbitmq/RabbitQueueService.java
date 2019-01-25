package com.open.springqianbailu.service.rabbitmq;

import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;

public interface RabbitQueueService {
    int insert(RabbitQueue record);

    void updateById(RabbitQueue message);
}