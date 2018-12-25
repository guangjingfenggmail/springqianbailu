package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.novel.Novel;
import com.open.springqianbailu.service.novel.NovelService;
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
@RequestMapping(value = "/novel")
public class NovelController  {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    public RedisUtil redisUtil;
    @Reference
    private NovelService novelService;

    @ApiOperation(value = "selectByMenuId", notes = "根据submenuId，pageSize，currentPosition获取小说信息{\"submenuId\":0,\"pageSize\":10,\"currentPosition\":0}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value = "/selectByMenuId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByMenuId(@RequestBody HashMap<String, Object> reqMap) {
        List<Novel> list = this.novelService.selectByMenuId(reqMap);
        Gson gson = new Gson();
        logger.info(TAG+"=="+gson.toJson(list));
        return Result.success(list);
    }

    @ApiOperation(value = "parseNovel", notes = "根据 submenuId，pageNo 获取小说信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "submenuId", value = "submenuId", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageNo", value = "pageNo", required = true, paramType = "path")
    })
    @RequestMapping(value = "/parseNovel/{submenuId}/{pageNo}", method = RequestMethod.POST)
    @ResponseBody
    public Result parseNovel(@PathVariable String submenuId, @PathVariable String pageNo) {
        List<Novel> list = (List<Novel>) redisUtil.get("parseNovel"+submenuId+pageNo);
        if (list==null || list.size()==0){
            NovelMessage message = new NovelMessage();
            message.submenuId = submenuId;
            message.pageNo = pageNo;
            novelService.parseNovel(message);

            return Result.error(0,"处理中...");
        }
        return Result.success(list);
    }

}
