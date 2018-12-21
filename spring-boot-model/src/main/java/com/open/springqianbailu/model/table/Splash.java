package com.open.springqianbailu.model.table;

import java.io.Serializable;

public class Splash implements Serializable {
    private Integer id;

    private String start;

    private String url;

    private String full_display_img_url;

    private String end;

    private String skip_url;

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


    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end == null ? null : end.trim();
    }

    public String getFull_display_img_url() {
        return full_display_img_url;
    }

    public void setFull_display_img_url(String full_display_img_url) {
        this.full_display_img_url = full_display_img_url;
    }

    public String getSkip_url() {
        return skip_url;
    }

    public void setSkip_url(String skip_url) {
        this.skip_url = skip_url;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }
}