package com.open.springqianbailu.model.table.viewtype;

import java.io.Serializable;

public class Action implements Serializable {
    private Integer id;

    private Integer item_id;

    private String type;

    private String path;

    private String extra;

    private String log_code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getLog_code() {
        return log_code;
    }

    public void setLog_code(String log_code) {
        this.log_code = log_code;
    }
}