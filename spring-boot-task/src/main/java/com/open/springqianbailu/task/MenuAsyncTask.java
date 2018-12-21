package com.open.springqianbailu.task;


import com.alibaba.dubbo.config.annotation.Reference;
import com.open.springqianbailu.documents.MenuDocumentDao;
import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.service.MenuSevice;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MenuAsyncTask {
    public static Random random = new Random();

    @Reference
    private MenuSevice menuSevice;

    @Async("taskExecutor")
    public void doTaskMenu() throws Exception {
        List<Menu> list = MenuDocumentDao.parseMenus();
        if (list!=null && list.size()>0){
            menuSevice.doTaskMenu(list);
        }
    }
}
