package com.open.springqianbailu.task;


import com.alibaba.dubbo.config.annotation.Reference;
import com.open.springqianbailu.documents.MenuDocumentDao;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.service.SubMenuSevice;
import com.open.springqianbailu.service.jsoup.JsoupSubMenuService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class SubMenuAsyncTask {
    public static Random random = new Random();

//    @Reference
//    private SubMenuSevice subMenuSevice;

    @Reference
    private JsoupSubMenuService jsoupSubMenuService;
    @Async("taskExecutor")
    public void doTaskMenu() throws Exception {
//        List<SubMenu> list = MenuDocumentDao.parseSubMenus();
//        if (list!=null && list.size()>0){
//            subMenuSevice.doTaskMenu(list);
//        }
//        jsoupSubMenuService.updateSubMenu();
    }
}
