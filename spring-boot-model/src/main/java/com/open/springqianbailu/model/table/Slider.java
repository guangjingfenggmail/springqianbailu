package com.open.springqianbailu.model.table;

import java.io.Serializable;

public class Slider implements Serializable {
    private Integer id;

    private String href;

    private String log_code;

    private String src;

    private String srcset;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getLog_code() {
        return log_code;
    }

    public void setLog_code(String log_code) {
        this.log_code = log_code;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public String getSrcset() {
        return srcset;
    }

    public void setSrcset(String srcset) {
        this.srcset = srcset == null ? null : srcset.trim();
    }
}