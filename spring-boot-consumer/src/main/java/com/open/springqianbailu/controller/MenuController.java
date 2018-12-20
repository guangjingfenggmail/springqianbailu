package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.service.MenuSevice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/menu")
public class MenuController   {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Reference
    private MenuSevice menuSevice;


    @ApiOperation(value = "getMenus", notes = "获取所有父菜单")
    @RequestMapping(value = "/getMenus", method = RequestMethod.GET)
    @ResponseBody
    public Result getMenus() {
        List<Menu> list = menuSevice.selectAll();
        Gson gson = new Gson();
        logger.info(TAG + gson.toJson(list));
        return Result.success(list);
    }


    @ApiOperation(value = "addMenu", notes = "新增menu{\"title\":\"图片\",\"href\":\"113\",\"type\":0}")
    @ApiImplicitParam(name = "menu", value = "menu", required = true, dataType = "Menu", paramType = "body")
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    @ResponseBody
    public Result addMenu(@RequestBody Menu menu) {
        int result = this.menuSevice.insert(menu);
        Gson gson = new Gson();
        logger.info(TAG + gson.toJson(menu));
        return Result.success(result);
    }


}
