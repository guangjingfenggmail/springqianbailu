package com.open.springqianbailu.model;

import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;

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
