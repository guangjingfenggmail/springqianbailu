package com.open.springqianbailu.dao;


import com.open.springqianbailu.model.table.TabCfgTable;

import java.util.List;

public interface TabCfgTableMapper  {
    int insert(TabCfgTable record);

    int insertSelective(TabCfgTable record);

    List<TabCfgTable> selectAll();

    void dropTable();

    void createTable();
}