package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.bean.AppStart;
import com.open.springqianbailu.model.bean.AppTabcfg;
import com.open.springqianbailu.model.bean.tab.TabCfgBean;
import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.model.table.TabCfgTable;
import com.open.springqianbailu.service.MenuSevice;
import com.open.springqianbailu.service.TabCfgTableService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping(value = "/menu")
public class MenuController   {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Reference
    private MenuSevice menuSevice;

    @Reference
    private TabCfgTableService tabCfgTableService;


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

    @ApiOperation(value = "appStart", notes = "抓起小米启动页面接口{\"phone_type\":\"PD1613\",\"phone_name\":\"UNLWVfdu8x6EVdwWYwO9mQTUlkSsYpGCWn/B/zou/IW/4vBZQiTB1xZTHuWS57Z39GzDqT/jFHDtT4mzqVSOXPrnitH4YY3aCBdaTN8+XVM=\",\"device\":\"nFDcqx4H+hs9YUE51Hw2/A==\" }")
    @ApiImplicitParam(name = "reqMap", value = "reqMap", required = true,  paramType = "body")
    @RequestMapping(value = "/appStart", method = RequestMethod.POST)
    @ResponseBody
    public AppStart appStart(@RequestBody HashMap<String,Object> reqMap) {
        AppStart result = this.menuSevice.appStart(reqMap);
        return result;
    }


    @ApiOperation(value = "appTabcfg", notes = "抓起小米启动页面接口{}")
    @ApiImplicitParam(name = "reqMap", value = "reqMap", required = true,  paramType = "body")
    @RequestMapping(value = "/appTabcfg", method = RequestMethod.POST)
    @ResponseBody
    public AppTabcfg appTabcfg(@RequestBody HashMap<String,Object> reqMap) {
        List<TabCfgTable> list = tabCfgTableService.selectAll();
        if (list==null || list.size()==0) {
            AppTabcfg result = this.menuSevice.appTabcfg(reqMap);
            return result;
        }
        AppTabcfg appTabcfg = new AppTabcfg();
        appTabcfg.code = 200;
        appTabcfg.indo = "Success";

        TabCfgBean data = new TabCfgBean();
        data.tab_bg = "";
        List<TabCfgTable> tab_config = new ArrayList<TabCfgTable>();
        data.tab_config = list;
        appTabcfg.data = data;
        return appTabcfg;
    }
}
