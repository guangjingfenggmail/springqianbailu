package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.bean.HomeAppInfo;
import com.open.springqianbailu.service.HomeAppinfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;

@Controller
@RequestMapping(value = "/home")
public class HomeTabController   {

    @Reference
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
