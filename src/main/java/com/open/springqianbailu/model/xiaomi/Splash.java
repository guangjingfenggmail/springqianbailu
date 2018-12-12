package com.open.springqianbailu.model.xiaomi;

import java.io.Serializable;

public class Splash implements Serializable {
    private Integer id;

    private String start;

    private String url;

    private String fullDisplayImgUrl;

    private String end;

    private String skipUrl;

    private String duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getFullDisplayImgUrl() {
        return fullDisplayImgUrl;
    }

    public void setFullDisplayImgUrl(String fullDisplayImgUrl) {
        this.fullDisplayImgUrl = fullDisplayImgUrl == null ? null : fullDisplayImgUrl.trim();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end == null ? null : end.trim();
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl == null ? null : skipUrl.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }
}