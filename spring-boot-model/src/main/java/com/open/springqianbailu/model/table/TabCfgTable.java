package com.open.springqianbailu.model.table;

import java.io.Serializable;

public class TabCfgTable implements Serializable {
    private Integer id;

    private String icon_normal;

    private String icon_selected;

    private String name;

    private String type;

    private String text_color_normal;

    private String text_color_selected;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}