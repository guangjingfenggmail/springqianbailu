package com.open.springqianbailu.service.jsoup;

import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.documents.MenuDocumentDao;
import com.open.springqianbailu.model.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("jsoupMenuService")
public class JsoupMenuServiceImpl implements JsoupMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public void updateMenu() {
        List<Menu> list = MenuDocumentDao.parseMenus();
        List<Menu> listDb = menuMapper.selectAll();
        if (listDb == null || listDb.size()==0) {
            for (Menu menu : list) {
                menuMapper.insert(menu);
            }
        }else {
            if (list.size()==listDb.size()) {
                for (int i = 0; i < listDb.size(); i++) {
                    Menu menu = list.get(i);
                    menu.setId(listDb.get(i).getId());
                    menuMapper.updateById(menu);
                }
            }
        }
    }
}
