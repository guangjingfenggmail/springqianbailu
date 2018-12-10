package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.rabbitmq.novel.NovelMessage;
import com.open.springqianbailu.service.jsoup.novel.JsoupNovelService;
import com.open.springqianbailu.service.novel.NovelService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_NOVEL_LIST_KEY;


@RestController
@RequestMapping(value = "/novel")
public class NovelController extends AbsController{
    @Resource
    private NovelService novelService;
    @Resource
    private JsoupNovelService jsoupNovelService;

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
        List<Novel> list = (List<Novel>) redisUtil.get(REDIS_NOVEL_LIST_KEY+submenuId+pageNo);
        if (list==null || list.size()==0){
            NovelMessage message = new NovelMessage();
            message.submenuId = submenuId;
            message.pageNo = pageNo;
            jsoupNovelService.parseNovel(message);

            return Result.error(0,"处理中...");
        }
        return Result.success(list);
    }

}
