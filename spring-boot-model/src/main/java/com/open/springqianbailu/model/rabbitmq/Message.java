package com.open.springqianbailu.model.rabbitmq;

import java.io.Serializable;

public class Message implements Serializable {
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
