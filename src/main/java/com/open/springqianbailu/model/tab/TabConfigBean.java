package com.open.springqianbailu.model.tab;

import java.io.Serializable;

public class TabConfigBean implements Serializable {
    public String icon_normal;
    public String icon_selected;
    public String name;
    public String type;
    public String text_color_normal;
    public String text_color_selected;
    public boolean show;

    public String getIcon_normal() {
        return icon_normal;
    }

    public void setIcon_normal(String icon_normal) {
        this.icon_normal = icon_normal;
    }

    public String getIcon_selected() {
        return icon_selected;
    }

    public void setIcon_selected(String icon_selected) {
        this.icon_selected = icon_selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText_color_normal() {
        return text_color_normal;
    }

    public void setText_color_normal(String text_color_normal) {
        this.text_color_normal = text_color_normal;
    }

    public String getText_color_selected() {
        return text_color_selected;
    }

    public void setText_color_selected(String text_color_selected) {
        this.text_color_selected = text_color_selected;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}