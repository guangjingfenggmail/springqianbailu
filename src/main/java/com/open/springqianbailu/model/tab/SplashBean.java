package com.open.springqianbailu.model.tab;

import java.io.Serializable;

public class SplashBean implements Serializable {
    public String ID;
    public String ShowTimes;
    public String start;
    public String url;
    public String full_display_img_url;
    public String end;
    public boolean skip_hide;
    public String skip_url;
    public String duration;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getShowTimes() {
        return ShowTimes;
    }

    public void setShowTimes(String showTimes) {
        ShowTimes = showTimes;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFull_display_img_url() {
        return full_display_img_url;
    }

    public void setFull_display_img_url(String full_display_img_url) {
        this.full_display_img_url = full_display_img_url;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isSkip_hide() {
        return skip_hide;
    }

    public void setSkip_hide(boolean skip_hide) {
        this.skip_hide = skip_hide;
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
        this.duration = duration;
    }
}
