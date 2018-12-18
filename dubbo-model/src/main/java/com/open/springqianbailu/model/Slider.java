package com.open.springqianbailu.model;

public class Slider {
    private Integer id;

    private String href;

    private String logCode;

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

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode == null ? null : logCode.trim();
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