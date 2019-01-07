package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.gallery.Gallery;
import com.open.springqianbailu.model.table.gallery.GalleryImage;
import com.open.springqianbailu.rabbitmq.QueueConfig;
import com.open.springqianbailu.service.gallery.GalleryImageService;
import com.open.springqianbailu.service.gallery.GalleryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/gallery")
public class GalleryController {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    public RedisUtil redisUtil;
    @Reference
    private GalleryService galleryService;

    @Reference
    private GalleryImageService  galleryImageService;

    @ApiOperation(value = "selectByMenuId", notes = "根据submenuId（1-8），pageSize，currentPosition获取图片信息{\"submenuId\":1,\"pageSize\":10,\"currentPosition\":0}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value = "/selectByMenuId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByMenuId(@RequestBody HashMap<String, Object> reqMap) {
        List<Gallery> list = this.galleryService.selectByMenuId(reqMap);
        Gson gson = new Gson();
        logger.info(TAG+"=="+gson.toJson(list));
        return Result.success(list);
    }


    @ApiOperation(value = "selectByDate", notes = "根据submenuId（1-8），createDate 获取图片信息{\"submenuId\":1,\"createDate\":\"2018-12-30\"}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value = "/selectByDate", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByDate(@RequestBody HashMap<String, Object> reqMap) {
        List<Gallery> list = this.galleryService.selectByDate(reqMap);
        Gson gson = new Gson();
        logger.info(TAG+"=="+gson.toJson(list));
        return Result.success(list);
    }


    @ApiOperation(value = "parseGallery", notes = "根据 submenuId（1-8），pageNo 获取图片信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "submenuId", value = "submenuId", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageNo", value = "pageNo", required = true, paramType = "path")
    })
    @RequestMapping(value = "/parseGallery/{submenuId}/{pageNo}", method = RequestMethod.POST)
    @ResponseBody
    public Result parseGallery(@PathVariable String submenuId, @PathVariable String pageNo) {
        List<Gallery> list = (List<Gallery>) redisUtil.get(TAG+"parseNovel"+submenuId+pageNo);
        if (list==null || list.size()==0){
            NovelMessage message = new NovelMessage();
            message.submenuId = submenuId;
            message.pageNo = pageNo;
            message.method = TAG+"parseNovel";
            message.uuid = UUID.randomUUID().toString();
            message.routingKey = QueueConfig.QUEUENAME_GALLERY;
            galleryService.parseNovel(message);

            return Result.error(0,"处理中...");
        }
        return Result.success(list);
    }

    @ApiOperation(value = "getImageList", notes = "根据 href，page 获取小说信息 {\"href\":\"/tttppp/996064.html\",\"page\":\"1\"}")
    @ApiImplicitParam(name = "map", value = "map", required = true, paramType = "body")
    @RequestMapping(value = "/getImageList", method = RequestMethod.POST)
    @ResponseBody
    public Result getImageList(@RequestBody HashMap<String,Object> map) {
        String href = (String) map.get("href");
        String page = (String) map.get("page");
        List<GalleryImage> list = galleryImageService.selectImage(href,page);
        return Result.success(list);
    }
}
