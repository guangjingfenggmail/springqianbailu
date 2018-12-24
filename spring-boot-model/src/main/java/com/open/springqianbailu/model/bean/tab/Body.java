package com.open.springqianbailu.model.bean.tab;


import com.open.springqianbailu.model.table.viewtype.Item;

import java.io.Serializable;
import java.util.List;

public class Body implements Serializable {
    private List<Item> items;
    private String line_color;
    private String line_height;
    private String title_logo_url;


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getLine_color() {
        return line_color;
    }

    public void setLine_color(String line_color) {
        this.line_color = line_color;
    }

    public String getLine_height() {
        return line_height;
    }

    public void setLine_height(String line_height) {
        this.line_height = line_height;
    }

    public String getTitle_logo_url() {
        return title_logo_url;
    }

    public void setTitle_logo_url(String title_logo_url) {
        this.title_logo_url = title_logo_url;
    }
}