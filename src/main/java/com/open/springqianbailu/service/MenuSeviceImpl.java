package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.model.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("menuSevice")
public class MenuSeviceImpl implements MenuSevice {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int insert(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public int insertSelective(Menu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }



}
