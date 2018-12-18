package com.open.springqianbailu.service.jsoup;

import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.documents.MenuDocumentDao;
import com.open.springqianbailu.interfaces.jsoup.JsoupSubMenuService;
import com.open.springqianbailu.model.SubMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("jsoupSubMenuService")
public class JsoupSubMenuServiceImpl implements JsoupSubMenuService {

    @Resource
    private SubMenuMapper subMenuMapper ;

    @Override
    public void updateSubMenu() {
        List<SubMenu> list = MenuDocumentDao.parseSubMenus();
        if (list!=null && list.size()>0){
            subMenuMapper.dropTable();
            subMenuMapper.createTable();
            for (SubMenu menu : list) {
                menu.setUpdateTime(System.currentTimeMillis()+"");
//                menuMapper.insert(menu);
            }
            subMenuMapper.insertBatch(list);
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
