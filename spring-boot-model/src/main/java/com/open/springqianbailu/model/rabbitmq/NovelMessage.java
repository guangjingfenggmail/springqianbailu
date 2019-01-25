package com.open.springqianbailu.model.rabbitmq;

import java.io.Serializable;

public class NovelMessage implements Serializable {
    public String submenuId;
    public String pageNo;
    public String method;
    public String uuid;
    public String routingKey;
    public int id;

}
