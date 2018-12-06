package com.open.springqianbailu.service;

import com.open.springqianbailu.model.Menu;

import java.util.List;

public interface MenuSevice extends AbsSevice{

    int insert(Menu menu);

    int insertSelective(Menu menu);

    List<Menu> selectAll();

    void updateById(Menu menu);

}
