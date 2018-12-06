package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.redis.RedisUtil;
import com.open.springqianbailu.service.jsoup.novel.JsoupNovelService;
import com.open.springqianbailu.service.novel.NovelService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;

@Controller
@RequestMapping(value = "/novel")
public class NovelController {
    static Logger logger = LoggerFactory.getLogger(NovelController.class.getSimpleName());
    @Resource
    private NovelService novelService;
    @Resource
    private JsoupNovelService jsoupNovelService;
    @Resource
    private RedisUtil redisUtil;

    @ApiOperation(value = "selectByMenuId", notes = "根据submenuId，pageSize，currentPosition获取小说信息{\"submenuId\":0,\"pageSize\":10,\"currentPosition\":0}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value = "/selectByMenuId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByMenuId(@RequestBody HashMap<String, Object> reqMap) {
        List<Novel> list = (List<Novel>) redisUtil.get(reqMap.toString());
        if (list==null || list.size()==0){
            list = this.novelService.selectByMenuId(reqMap);
            redisUtil.lSet(reqMap.toString(),list,REDIS_EXPIRE_TIME);
        }
        Gson gson = new Gson();
        logger.info("NovelController=="+gson.toJson(list));
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
        int result = this.jsoupNovelService.parseNovel(submenuId,pageNo);
        return Result.success(result);
    }

}
