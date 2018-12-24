package com.open.springqianbailu.model.bean.tab;


import java.io.Serializable;

public class ViewTypeBean implements Serializable {

    private String view_type;
    private String stat;
    private Body body;

    public String getView_type() {
        return view_type;
    }

    public void setView_type(String view_type) {
        this.view_type = view_type;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }


}
