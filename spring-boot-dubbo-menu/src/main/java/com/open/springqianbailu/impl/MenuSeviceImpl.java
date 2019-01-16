package com.open.springqianbailu.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.service.MenuSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.open.springqianbailu.dao.MenuMapper;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;


@Component
@Service(interfaceClass = MenuSevice.class) //dubbo的service，注入接口
public class MenuSeviceImpl  implements MenuSevice {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    public RedisUtil redisUtil;

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Autowired
    private RestTemplate restTemplate;



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
        List<Menu> list = (List<Menu>) redisUtil.get("MenuSevice"+"selectAll");
        if (list == null || list.size() == 0) {
            list = menuMapper.selectAll();
            redisUtil.set("MenuSevice"+"selectAll", list, REDIS_EXPIRE_TIME);
        }
        return list;
    }


    @Override
    public void updateById(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        menuMapper.updateById(menu);
    }

    @Override
    public void doTaskMenu(List<Menu> list) {
        if (list!=null && list.size()>0){
            menuMapper.dropTable();
            menuMapper.createTable();
            for (Menu menu : list) {
                menu.setUpdateTime(System.currentTimeMillis()+"");
            }
            menuMapper.insertBatch(list);
        }
    }


}
