package com.open.springqianbailu.service;


import com.open.springqianbailu.model.table.Menu;

import java.util.List;

public interface MenuSevice  {

    int insert(Menu menu);

    int insertSelective(Menu menu);

    List<Menu> selectAll();

    void updateById(Menu menu);

    void doTaskMenu(List<Menu> list);

}
