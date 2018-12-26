package com.open.springqianbailu.model.table.viewtype;

import java.io.Serializable;
import java.util.List;

public class ViewTypeBodyTable implements Serializable {
    private Integer id;

    private Integer view_type_id;

    private String line_color;

    private Double line_height;

    private String w;

    private String h;

    private String bg_color;

    private String recommend_flag;

    private List<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getView_type_id() {
        return view_type_id;
    }

    public void setView_type_id(Integer view_type_id) {
        this.view_type_id = view_type_id;
    }

    public String getLine_color() {
        return line_color;
    }

    public void setLine_color(String line_color) {
        this.line_color = line_color;
    }

    public Double getLine_height() {
        return line_height;
    }

    public void setLine_height(Double line_height) {
        this.line_height = line_height;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getBg_color() {
        return bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public String getRecommend_flag() {
        return recommend_flag;
    }

    public void setRecommend_flag(String recommend_flag) {
        this.recommend_flag = recommend_flag;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}