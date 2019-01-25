package com.open.springqianbailu.task;


import com.alibaba.dubbo.config.annotation.Reference;
import com.open.springqianbailu.service.video.VideoService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class VideoAsyncTask {
    public static Random random = new Random();

    @Reference
    private VideoService videoService;

    @Async("taskExecutor")
    public void updateList()   {
        videoService.updateList();
    }
}
