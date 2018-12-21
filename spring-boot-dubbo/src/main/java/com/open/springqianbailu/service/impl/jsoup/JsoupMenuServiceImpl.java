package com.open.springqianbailu.service.impl.jsoup;

import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.documents.MenuDocumentDao;
import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.service.MenuSevice;
import com.open.springqianbailu.service.jsoup.JsoupMenuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = JsoupMenuService.class) //dubbo的service，注入接口
public class JsoupMenuServiceImpl implements JsoupMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public void updateMenu() {
        List<Menu> list = MenuDocumentDao.parseMenus();
        if (list!=null && list.size()>0){
            menuMapper.dropTable();
            menuMapper.createTable();
            for (Menu menu : list) {
                menu.setUpdateTime(System.currentTimeMillis()+"");
//                menuMapper.insert(menu);
            }
            menuMapper.insertBatch(list);
        }
//        List<Menu> listDb = menuMapper.selectAll();
//        if (listDb == null || listDb.size()==0) {
//            for (Menu menu : list) {
//                menu.setUpdateTime(System.currentTimeMillis()+"");
//                menuMapper.insert(menu);
//            }
//        }else {
//            if (list.size()==listDb.size()) {
//                for (int i = 0; i < listDb.size(); i++) {
//                    Menu menu = list.get(i);
//                    menu.setId(listDb.get(i).getId());
//                    menu.setUpdateTime(System.currentTimeMillis()+"");
//                    menuMapper.updateById(menu);
//                }
//            }
//        }
    }
}
