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
        for (Menu menu:list){
            menuMapper.insert(menu);
        }

    }
}
