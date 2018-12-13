package com.open.springqianbailu.model.xiaomi;

import java.io.Serializable;

public class TabCfgTable implements Serializable {
    private Integer id;

    private String iconNormal;

    private String iconSelected;

    private String name;

    private String type;

    private String textColorNormal;

    private String textColorSelected;

    private String show;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIconNormal() {
        return iconNormal;
    }

    public void setIconNormal(String iconNormal) {
        this.iconNormal = iconNormal == null ? null : iconNormal.trim();
    }

    public String getIconSelected() {
        return iconSelected;
    }

    public void setIconSelected(String iconSelected) {
        this.iconSelected = iconSelected == null ? null : iconSelected.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTextColorNormal() {
        return textColorNormal;
    }

    public void setTextColorNormal(String textColorNormal) {
        this.textColorNormal = textColorNormal == null ? null : textColorNormal.trim();
    }

    public String getTextColorSelected() {
        return textColorSelected;
    }

    public void setTextColorSelected(String textColorSelected) {
        this.textColorSelected = textColorSelected == null ? null : textColorSelected.trim();
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show == null ? null : show.trim();
    }
}