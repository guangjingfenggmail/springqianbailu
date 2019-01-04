package com.open.springqianbailu.task;


import com.alibaba.dubbo.config.annotation.Reference;
import com.open.springqianbailu.service.gallery.GalleryService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GalleryAsyncTask {
    public static Random random = new Random();

    @Reference
    private GalleryService galleryService;

    @Async("taskExecutor")
    public void updateList()   {
        galleryService.updateList();
    }
}
