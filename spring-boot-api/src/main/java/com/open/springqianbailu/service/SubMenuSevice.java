package com.open.springqianbailu.service;


import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.model.table.SubMenu;

import java.util.List;

public interface SubMenuSevice  {

    int insert(SubMenu subMenu);

    int insertSelective(SubMenu subMenu);

    List<SubMenu> selectByMenuId(Integer menuId);

    void doTaskMenu(List<SubMenu> list);

    SubMenu selectById(Integer id);
}
