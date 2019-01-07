package com.open.springqianbailu.scheduling;


import com.open.springqianbailu.task.VideoAsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
@EnableScheduling
public class VideoListSchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private VideoAsyncTask videoAsyncTask;

    @Scheduled(cron = "0 0/1 * * * ?") // 每1分钟执行一次
    public void updateList() {
        logger.info("updateQueue 定时任务启动");
        videoAsyncTask.updateList();
    }

}
