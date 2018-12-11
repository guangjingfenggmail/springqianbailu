package com.open.springqianbailu.scheduling;


import com.open.springqianbailu.async.MenuAsyncTask;
import com.open.springqianbailu.service.jsoup.JsoupMenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
@EnableScheduling
public class MenuSchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());
//    @Resource
//    private JsoupMenuServiceImpl jsoupMenuService;

    @Autowired
    private MenuAsyncTask menuAsyncTask;

    @Scheduled(cron = "0 0/1 * * * ?") // 每1分钟执行一次
    public void updateMenu() throws Exception {
        logger.info("updateMenu 定时任务启动");
//        jsoupMenuService.updateMenu();

//        menuAsyncTask.doTaskMenu();
//        Thread.currentThread().join();

    }

}
