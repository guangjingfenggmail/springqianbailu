package com.open.springqianbailu.scheduling;


import com.open.springqianbailu.task.NovelAsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
@EnableScheduling
public class NovelListSchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private NovelAsyncTask novelAsyncTask;

    @Scheduled(cron = "0 0/1 * * * ?") // 每10分钟执行一次
    public void updateNovelList() {
        logger.info("updateQueue 定时任务启动");
//        novelAsyncTask.updateNovelList();
    }

}
