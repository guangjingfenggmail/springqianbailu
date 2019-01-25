package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.table.rabbitmq.RabbitMessage;
import com.open.springqianbailu.service.rabbitmq.RabbitMessageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/rabbitmq")
public class RabbitMessageController {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());


    @Reference
    private RabbitMessageService rabbitMessageService;

    @ApiOperation(value = "selectAll", notes = "获取所有mq任务")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public Result selectAll(){
        List<RabbitMessage> list = rabbitMessageService.selectAll();
        Gson gson = new Gson();
        logger.info(TAG + gson.toJson(list));
        return Result.success(list);
    }

    @ApiOperation(value = "selectById", notes = "根据 uuid，status 获取小说信息 {\"uuid\":\"\",\"status\":\"1\"}")
    @ApiImplicitParam(name = "map", value = "map", required = true, paramType = "body")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @ResponseBody
    public Result selectById(@RequestBody HashMap<String,Object> map){
        List<RabbitMessage> list = rabbitMessageService.selectById(map);
        Gson gson = new Gson();
        logger.info(TAG + gson.toJson(list));
        return Result.success(list);
    }

}
