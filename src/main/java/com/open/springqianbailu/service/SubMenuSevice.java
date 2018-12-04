package com.open.springqianbailu.service;

import com.open.springqianbailu.model.SubMenu;

import java.util.List;

public interface SubMenuSevice {

    int insert(SubMenu subMenu);

    int insertSelective(SubMenu subMenu);

    List<SubMenu> selectByMenuId(Integer menuId);
}
