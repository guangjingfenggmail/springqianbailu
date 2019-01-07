package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.video.Video;
import com.open.springqianbailu.service.video.VideoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/video")
public class VideoController {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    public RedisUtil redisUtil;
    @Reference
    private VideoService videoService;


    @ApiOperation(value = "selectByMenuId", notes = "根据submenuId（17-32），pageSize，currentPosition获取视频信息{\"submenuId\":17,\"pageSize\":10,\"currentPosition\":0}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value = "/selectByMenuId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByMenuId(@RequestBody HashMap<String, Object> reqMap) {
        List<Video> list = this.videoService.selectByMenuId(reqMap);
        Gson gson = new Gson();
        logger.info(TAG+"=="+gson.toJson(list));
        return Result.success(list);
    }


    @ApiOperation(value = "selectByDate", notes = "根据submenuId（17-32），createDate 获取视频信息{\"submenuId\":17,\"createDate\":\"2018-12-30\"}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value = "/selectByDate", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByDate(@RequestBody HashMap<String, Object> reqMap) {
        List<Video> list = this.videoService.selectByDate(reqMap);
        Gson gson = new Gson();
        logger.info(TAG+"=="+gson.toJson(list));
        return Result.success(list);
    }


    @ApiOperation(value = "parseGallery", notes = "根据 submenuId（17-32），pageNo 获取视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "submenuId", value = "submenuId", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageNo", value = "pageNo", required = true, paramType = "path")
    })
    @RequestMapping(value = "/parseGallery/{submenuId}/{pageNo}", method = RequestMethod.POST)
    @ResponseBody
    public Result parseGallery(@PathVariable String submenuId, @PathVariable String pageNo) {
        List<Video> list = (List<Video>) redisUtil.get(TAG+"parseNovel"+submenuId+pageNo);
        if (list==null || list.size()==0){
            NovelMessage message = new NovelMessage();
            message.submenuId = submenuId;
            message.pageNo = pageNo;
            videoService.parseVideo(message);

            return Result.error(0,"处理中...");
        }
        return Result.success(list);
    }


}
