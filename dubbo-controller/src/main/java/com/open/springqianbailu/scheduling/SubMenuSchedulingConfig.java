//package com.open.springqianbailu.scheduling;
//
//
//import com.open.springqianbailu.service.jsoup.JsoupSubMenuServiceImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import javax.annotation.Resource;
//
//@Configuration
//@EnableScheduling
//public class SubMenuSchedulingConfig {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//    @Resource
//    private JsoupSubMenuServiceImpl jsoupSubMenuService;
//
//    @Scheduled(cron = "0 0/1 * * * ?") // 每2分钟执行一次
//    public void updateMenu() {
//        logger.info("updateSubMenu 定时任务启动");
////        jsoupSubMenuService.updateSubMenu();
//    }
//
//}
