package com.open.springqianbailu.interfaces.xiaomi;

import com.open.springqianbailu.interfaces.AbsSevice;
import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;

import java.util.List;

public interface HomeAppinfoService extends AbsSevice {
    int insert(HomeAppinfoTable record);

    int insertSelective(HomeAppinfoTable record);

    List<HomeAppinfoTable> selectAll();
}