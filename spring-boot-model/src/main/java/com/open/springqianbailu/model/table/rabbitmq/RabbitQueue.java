package com.open.springqianbailu.model.table.rabbitmq;

import java.io.Serializable;

public class RabbitQueue implements Serializable {
    private Integer id;

    private Integer rabbit_mq_id;

    private String uuid;

    private String routingKey;

    private Integer status;

    private Integer ack;

    private String cause;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRabbit_mq_id() {
        return rabbit_mq_id;
    }

    public void setRabbit_mq_id(Integer rabbit_mq_id) {
        this.rabbit_mq_id = rabbit_mq_id;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public Integer getAck() {
        return ack;
    }

    public void setAck(Integer ack) {
        this.ack = ack;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }
}