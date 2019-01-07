package com.open.springqianbailu.dao.rabbitmq;

import com.open.springqianbailu.model.table.rabbitmq.RabbitMessage;

import java.util.HashMap;
import java.util.List;

public interface RabbitMessageMapper {
    int insert(RabbitMessage record);

    List<RabbitMessage> selectAll();

    List<RabbitMessage> selectById(HashMap map);

    List<RabbitMessage> selectByUUId(String uuid);

    void dropTable();

    void createTable();
}