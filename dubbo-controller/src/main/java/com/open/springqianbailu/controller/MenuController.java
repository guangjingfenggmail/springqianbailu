package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.interfaces.MenuSevice;
import com.open.springqianbailu.interfaces.xiaomi.TabCfgTableService;
import com.open.springqianbailu.model.AppStart;
import com.open.springqianbailu.model.AppTabcfg;
import com.open.springqianbailu.model.Menu;
import com.open.springqianbailu.model.tab.TabCfgBean;
import com.open.springqianbailu.model.tab.TabConfigBean;
import com.open.springqianbailu.model.xiaomi.TabCfgTable;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping(value = "/menu")
public class MenuController extends AbsController {
    @Resource
    private MenuSevice menuSevice;

    @Resource
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
        List<TabConfigBean> tab_config = new ArrayList<TabConfigBean>();

        TabConfigBean bean;
        for (TabCfgTable tabCfgTable:list){
            bean = new TabConfigBean();
            bean.icon_normal = tabCfgTable.getIconNormal();
            bean.icon_selected = tabCfgTable.getIconSelected();
            bean.text_color_normal = tabCfgTable.getTextColorNormal();
            bean.text_color_selected = tabCfgTable.getTextColorSelected();
            bean.name = tabCfgTable.getName();
            bean.type = tabCfgTable.getType();
            tab_config.add(bean);
        }

        data.tab_config = tab_config;
        appTabcfg.data = data;
        return appTabcfg;
    }
}
