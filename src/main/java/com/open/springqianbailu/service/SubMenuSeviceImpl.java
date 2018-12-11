package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.interfaces.SubMenuSevice;
import com.open.springqianbailu.model.SubMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_SUBMENU_LIST_KEY;

@Service("subMenuSevice")
public class SubMenuSeviceImpl extends AbsServiceImpl implements SubMenuSevice {

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
        List<SubMenu> list = (List<SubMenu>) redisUtil.get(REDIS_SUBMENU_LIST_KEY+menuId);
        if (list==null || list.size()==0){
            list = subMenuMapper.selectByMenuId(menuId);
            redisUtil.set(REDIS_SUBMENU_LIST_KEY+menuId,list,REDIS_EXPIRE_TIME);
        }
        return list;
    }
}
