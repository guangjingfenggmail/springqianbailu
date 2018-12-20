package com.open.springqianbailu.dao;


import com.open.springqianbailu.model.table.HomeAppinfoTable;

import java.util.List;

public interface HomeAppinfoTableMapper  {
    int insert(HomeAppinfoTable record);

    int insertSelective(HomeAppinfoTable record);

    List<HomeAppinfoTable> selectAll();

    void insertBatch(List<HomeAppinfoTable> list);

    void dropTable();

    void createTable();
}