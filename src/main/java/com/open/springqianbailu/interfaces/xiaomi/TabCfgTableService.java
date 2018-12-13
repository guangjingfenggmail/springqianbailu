package com.open.springqianbailu.interfaces.xiaomi;

import com.open.springqianbailu.interfaces.AbsSevice;
import com.open.springqianbailu.model.xiaomi.TabCfgTable;

public interface TabCfgTableService extends AbsSevice {
    int insert(TabCfgTable record);

    int insertSelective(TabCfgTable record);

    void dropTable();

    void createTable();
}