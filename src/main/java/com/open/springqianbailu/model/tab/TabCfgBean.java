package com.open.springqianbailu.model.tab;


import java.io.Serializable;
import java.util.List;

public class TabCfgBean implements Serializable {
    public String tab_bg;
    public List<TabConfigBean> tab_config;

    public String getTab_bg() {
        return tab_bg;
    }

    public void setTab_bg(String tab_bg) {
        this.tab_bg = tab_bg;
    }

    public List<TabConfigBean> getTab_config() {
        return tab_config;
    }

    public void setTab_config(List<TabConfigBean> tab_config) {
        this.tab_config = tab_config;
    }
}