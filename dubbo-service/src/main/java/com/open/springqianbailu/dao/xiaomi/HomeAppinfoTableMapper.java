package com.open.springqianbailu.dao.xiaomi;

import com.open.springqianbailu.dao.AbsMapper;
import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;

import java.util.List;

public interface HomeAppinfoTableMapper extends AbsMapper {
    int insert(HomeAppinfoTable record);

    int insertSelective(HomeAppinfoTable record);

    List<HomeAppinfoTable> selectAll();

    void insertBatch(List<HomeAppinfoTable> list);
}