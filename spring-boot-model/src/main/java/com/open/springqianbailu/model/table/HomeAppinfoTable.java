package com.open.springqianbailu.model.table;

import java.io.Serializable;

public class HomeAppinfoTable implements Serializable {
    private Integer id;

    private String tab_name;

    private String tab_api;

    private String word_selected_color;

    private String word_unselected_color;

    private String bg_img;

    private String bg_img_webp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTab_name() {
        return tab_name;
    }

    public void setTab_name(String tab_name) {
        this.tab_name = tab_name;
    }

    public String getTab_api() {
        return tab_api;
    }

    public void setTab_api(String tab_api) {
        this.tab_api = tab_api;
    }

    public String getWord_selected_color() {
        return word_selected_color;
    }

    public void setWord_selected_color(String word_selected_color) {
        this.word_selected_color = word_selected_color;
    }

    public String getWord_unselected_color() {
        return word_unselected_color;
    }

    public void setWord_unselected_color(String word_unselected_color) {
        this.word_unselected_color = word_unselected_color;
    }

    public String getBg_img() {
        return bg_img;
    }

    public void setBg_img(String bg_img) {
        this.bg_img = bg_img;
    }

    public String getBg_img_webp() {
        return bg_img_webp;
    }

    public void setBg_img_webp(String bg_img_webp) {
        this.bg_img_webp = bg_img_webp;
    }
}