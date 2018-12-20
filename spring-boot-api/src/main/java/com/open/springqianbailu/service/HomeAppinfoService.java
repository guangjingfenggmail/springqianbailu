package com.open.springqianbailu.service;


import com.open.springqianbailu.model.table.HomeAppinfoTable;

import java.util.List;

public interface HomeAppinfoService  {
    int insert(HomeAppinfoTable record);

    int insertSelective(HomeAppinfoTable record);

    List<HomeAppinfoTable> selectAll();
}