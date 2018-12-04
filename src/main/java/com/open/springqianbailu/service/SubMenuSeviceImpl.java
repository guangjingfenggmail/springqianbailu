package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.model.SubMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("subMenuSevice")
public class SubMenuSeviceImpl implements SubMenuSevice {

    @Resource
    private SubMenuMapper subMenuMapper;

    @Override
    public int insert(SubMenu subMenu) {
        return subMenuMapper.insert(subMenu);
    }

    @Override
    public int insertSelective(SubMenu subMenu) {
        return subMenuMapper.insertSelective(subMenu);
    }

    @Override
    public List<SubMenu> selectByMenuId(Integer menuId) {
        return subMenuMapper.selectByMenuId(menuId);
    }
}
