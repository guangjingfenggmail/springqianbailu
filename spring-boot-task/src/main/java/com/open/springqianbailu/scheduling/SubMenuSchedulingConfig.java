package com.open.springqianbailu.scheduling;


import com.open.springqianbailu.task.SubMenuAsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class SubMenuSchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SubMenuAsyncTask subMenuAsyncTask;

    @Scheduled(cron = "0 0/1 * * * ?") // 每2分钟执行一次
    public void updateMenu()  throws Exception{
        logger.info("updateSubMenu 定时任务启动");
        subMenuAsyncTask.doTaskMenu();
        Thread.currentThread().join();
    }

}
