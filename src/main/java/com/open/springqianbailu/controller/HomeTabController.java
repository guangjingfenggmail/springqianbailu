package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.interfaces.xiaomi.HomeAppinfoService;
import com.open.springqianbailu.model.HomeAppInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/home")
public class HomeTabController extends AbsController {

    @Resource
    private HomeAppinfoService homeAppinfoService;


    @ApiOperation(value = "getAppInfo", notes = "获取home顶部tab菜单")
    @RequestMapping(value = "/getAppInfo", method = RequestMethod.GET)
    @ResponseBody
    public Result getAppInfo() {
        HomeAppInfo homeAppInfo = new HomeAppInfo();
        homeAppInfo.setTabs(homeAppinfoService.selectAll());
        return Result.success(homeAppInfo);
    }
}
