package com.open.springqianbailu.model.rabbitmq;

import java.io.Serializable;

public class Message implements Serializable {
    private String param;
    private String param2;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}
