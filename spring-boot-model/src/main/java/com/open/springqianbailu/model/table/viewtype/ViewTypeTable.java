package com.open.springqianbailu.model.table.viewtype;


import java.io.Serializable;

public class ViewTypeTable implements Serializable {
    private Integer id;

    private String stat;

    private String block_id;

    private String view_type;

    private String tab_data_type;

    private String tab_api;

    private ViewTypeBodyTable body;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getBlock_id() {
        return block_id;
    }

    public void setBlock_id(String block_id) {
        this.block_id = block_id;
    }

    public String getView_type() {
        return view_type;
    }

    public void setView_type(String view_type) {
        this.view_type = view_type;
    }

    public ViewTypeBodyTable getBody() {
        return body;
    }

    public void setBody(ViewTypeBodyTable body) {
        this.body = body;
    }

    public String getTab_data_type() {
        return tab_data_type;
    }

    public void setTab_data_type(String tab_data_type) {
        this.tab_data_type = tab_data_type;
    }

    public String getTab_api() {
        return tab_api;
    }

    public void setTab_api(String tab_api) {
        this.tab_api = tab_api;
    }
}