package com.open.springqianbailu.service;

import com.open.springqianbailu.model.SubMenu;

import java.util.List;

public interface SubMenuSevice extends AbsSevice{

    int insert(SubMenu subMenu);

    int insertSelective(SubMenu subMenu);

    List<SubMenu> selectByMenuId(Integer menuId);
}
