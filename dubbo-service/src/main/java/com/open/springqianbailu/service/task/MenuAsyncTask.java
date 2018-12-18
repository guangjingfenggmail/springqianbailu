package com.open.springqianbailu.service.task;


import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.documents.MenuDocumentDao;
import com.open.springqianbailu.model.Menu;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Component
public class MenuAsyncTask {

    public static Random random = new Random();
    @Resource
    private MenuMapper menuMapper;

    @Async("taskExecutor")
    public void doTaskMenu() throws Exception {
        List<Menu> list = MenuDocumentDao.parseMenus();
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
