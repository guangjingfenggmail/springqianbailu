package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.service.novel.NovelService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/novel")
public class NovelController {

    @Resource
    private NovelService novelService;


    @ApiOperation(value = "selectByMenuId", notes = "根据submenuId，pageSize，currentPosition获取小说信息{\"submenuId\":0,\"pageSize\":10,\"currentPosition\":0}")
    @ApiImplicitParam(name = "reqMap", value = "用户reqMap", required = true, paramType = "body")
    @RequestMapping(value = "/selectByMenuId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByMenuId(@RequestBody HashMap<String, Object> reqMap) {
        List<Novel> list = this.novelService.selectByMenuId(reqMap);
        return Result.success(list);
    }
}
