package com.open.springqianbailu.dao;

import com.open.springqianbailu.model.Menu;

import java.util.List;

public interface MenuMapper extends AbsMapper {
    int insert(Menu menu);

    int insertSelective(Menu menu);

    List<Menu> selectAll();

    void updateById(Menu menu);

    int insertBatch(List<Menu> menu);
}