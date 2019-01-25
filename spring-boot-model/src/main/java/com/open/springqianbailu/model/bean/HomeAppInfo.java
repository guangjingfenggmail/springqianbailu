package com.open.springqianbailu.model.bean;


import com.open.springqianbailu.model.table.HomeAppinfoTable;

import java.io.Serializable;
import java.util.List;

public class HomeAppInfo implements Serializable {
    private List<HomeAppinfoTable> tabs;

    public List<HomeAppinfoTable> getTabs() {
        return tabs;
    }

    public void setTabs(List<HomeAppinfoTable> tabs) {
        this.tabs = tabs;
    }
}
