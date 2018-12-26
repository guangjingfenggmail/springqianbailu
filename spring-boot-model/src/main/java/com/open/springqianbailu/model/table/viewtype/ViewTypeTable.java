package com.open.springqianbailu.model.table.viewtype;

public class ViewTypeTable {
    private Integer id;

    private String stat;

    private String block_id;

    private String view_type;

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
}