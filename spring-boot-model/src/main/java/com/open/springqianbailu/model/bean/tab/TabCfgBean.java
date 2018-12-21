package com.open.springqianbailu.model.bean.tab;


import com.open.springqianbailu.model.table.TabCfgTable;

import java.io.Serializable;
import java.util.List;

public class TabCfgBean implements Serializable {
    public String tab_bg;
    public List<TabCfgTable> tab_config;

    public String getTab_bg() {
        return tab_bg;
    }

    public void setTab_bg(String tab_bg) {
        this.tab_bg = tab_bg;
    }

    public List<TabCfgTable> getTab_config() {
        return tab_config;
    }

    public void setTab_config(List<TabCfgTable> tab_config) {
        this.tab_config = tab_config;
    }
}