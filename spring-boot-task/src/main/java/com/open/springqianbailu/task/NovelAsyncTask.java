package com.open.springqianbailu.task;


import com.alibaba.dubbo.config.annotation.Reference;
import com.open.springqianbailu.service.novel.NovelService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NovelAsyncTask {
    public static Random random = new Random();

    @Reference
    private NovelService novelService;

    @Async("taskExecutor")
    public void updateNovelList()   {
        novelService.updateNovelList();
    }
}
