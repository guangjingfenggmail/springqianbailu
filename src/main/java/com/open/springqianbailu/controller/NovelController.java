package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.service.jsoup.novel.JsoupNovelService;
import com.open.springqianbailu.service.novel.NovelService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/novel")
public class NovelController {

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