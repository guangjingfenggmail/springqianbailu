package com.open.springqianbailu.service;

import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.model.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_MENU_LIST_KEY;


@Service("menuSevice")
public class MenuSeviceImpl extends AbsServiceImpl implements MenuSevice {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int insert(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        return menuMapper.insert(menu);
    }

    @Override
    public int insertSelective(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        return menuMapper.insertSelective(menu);
    }

    @Override
    public List<Menu> selectAll() {
        List<Menu> list = (List<Menu>) redisUtil.get(REDIS_MENU_LIST_KEY);
        if (list == null || list.size() == 0) {
            list = menuMapper.selectAll();
            redisUtil.set(REDIS_MENU_LIST_KEY, list, REDIS_EXPIRE_TIME);
        }
        return list;
    }


    @Override
    public void updateById(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        menuMapper.updateById(menu);
    }


}
