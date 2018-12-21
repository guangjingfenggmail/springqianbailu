package com.open.springqianbailu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.service.SubMenuSevice;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;


@Component
@Service(interfaceClass = SubMenuSevice.class) //dubbo的service，注入接口
public class SubMenuSeviceImpl   implements SubMenuSevice {
    @Resource
    public RedisUtil redisUtil;

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
        List<SubMenu> list = (List<SubMenu>) redisUtil.get("SubMenuSevice"+"selectByMenuId"+menuId);
        if (list==null || list.size()==0){
            list = subMenuMapper.selectByMenuId(menuId);
            redisUtil.set("SubMenuSevice"+"selectByMenuId"+menuId,list,REDIS_EXPIRE_TIME);
        }
        return list;
    }

    @Override
    public void doTaskMenu(List<SubMenu> list) {
        if (list!=null && list.size()>0){
            subMenuMapper.dropTable();
            subMenuMapper.createTable();
            for (SubMenu menu : list) {
                menu.setUpdateTime(System.currentTimeMillis()+"");
//                menuMapper.insert(menu);
            }
            subMenuMapper.insertBatch(list);
        }
    }
}
