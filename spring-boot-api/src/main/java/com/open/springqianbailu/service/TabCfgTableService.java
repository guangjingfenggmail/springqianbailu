package com.open.springqianbailu.service;


import com.open.springqianbailu.model.table.TabCfgTable;

import java.util.List;

public interface TabCfgTableService  {
    int insert(TabCfgTable record);

    int insertSelective(TabCfgTable record);

    void dropTable();

    void createTable();

    List<TabCfgTable> selectAll();
}