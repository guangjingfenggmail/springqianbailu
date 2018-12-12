package com.open.springqianbailu.interfaces;

import com.open.springqianbailu.model.AppStart;
import com.open.springqianbailu.model.Menu;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;

public interface MenuSevice extends AbsSevice{

    int insert(Menu menu);

    int insertSelective(Menu menu);

    List<Menu> selectAll();

    void updateById(Menu menu);

    AppStart appStart(HashMap<String,Object> map);

}
