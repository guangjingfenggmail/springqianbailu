package com.open.springqianbailu.service;


import com.open.springqianbailu.model.bean.AppStart;
import com.open.springqianbailu.model.bean.AppTabcfg;
import com.open.springqianbailu.model.table.Menu;

import java.util.HashMap;
import java.util.List;

public interface MenuSevice  {

    int insert(Menu menu);

    int insertSelective(Menu menu);

    List<Menu> selectAll();

    void updateById(Menu menu);

    void doTaskMenu(List<Menu> list);

    AppStart appStart(HashMap<String,Object> map);

    AppTabcfg appTabcfg(HashMap<String, Object> map) ;

}
