package com.open.springqianbailu.dao.rabbitmq;

import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;

public interface RabbitQueueMapper {
    int insert(RabbitQueue record);

    void updateById(RabbitQueue message);

    void dropTable();

    void createTable();
}