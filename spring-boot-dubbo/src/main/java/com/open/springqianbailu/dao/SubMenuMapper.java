package com.open.springqianbailu.dao;


import com.open.springqianbailu.model.table.SubMenu;

import java.util.List;

public interface SubMenuMapper  {
    int insert(SubMenu record);

    int insertSelective(SubMenu record);

    List<SubMenu> selectByMenuId(Integer menuId);

    int insertBatch(List<SubMenu> menu);


     SubMenu selectById(Integer id);

    void dropTable();

    void createTable();
}