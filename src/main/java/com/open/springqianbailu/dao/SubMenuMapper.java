package com.open.springqianbailu.dao;

import com.open.springqianbailu.model.Menu;
import com.open.springqianbailu.model.SubMenu;

import java.util.List;

public interface SubMenuMapper extends AbsMapper{
    int insert(SubMenu record);

    int insertSelective(SubMenu record);

    List<SubMenu> selectByMenuId(Integer menuId);

    int insertBatch(List<SubMenu> menu);


     SubMenu selectById(Integer id);
}