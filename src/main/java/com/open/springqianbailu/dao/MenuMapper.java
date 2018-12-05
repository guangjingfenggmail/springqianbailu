package com.open.springqianbailu.dao;

import com.open.springqianbailu.model.Menu;

import java.util.List;

public interface MenuMapper {
    int insert(Menu menu);

    int insertSelective(Menu menu);

    List<Menu> selectAll();

    void updateById(Menu menu);

    void dropTable();

    void createTable();

    int insertBatch(List<Menu> menu);
}