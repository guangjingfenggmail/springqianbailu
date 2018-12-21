package com.open.springqianbailu.model.xiaomi.viewtype;

public class Item {
    private Integer id;

    private Integer sections_index;

    private String img_url;

    private String img_url_webp;

    private String img_url_color;

    private Integer w;

    private Integer h;

    private Integer ad_position_id;

    private Integer material_id;

    private String view_type;

    private String stat;

    private Action action;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSections_index() {
        return sections_index;
    }

    public void setSections_index(Integer sections_index) {
        this.sections_index = sections_index;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_url_webp() {
        return img_url_webp;
    }

    public void setImg_url_webp(String img_url_webp) {
        this.img_url_webp = img_url_webp;
    }

    public String getImg_url_color() {
        return img_url_color;
    }

    public void setImg_url_color(String img_url_color) {
        this.img_url_color = img_url_color;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getAd_position_id() {
        return ad_position_id;
    }

    public void setAd_position_id(Integer ad_position_id) {
        this.ad_position_id = ad_position_id;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public String getView_type() {
        return view_type;
    }

    public void setView_type(String view_type) {
        this.view_type = view_type;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}