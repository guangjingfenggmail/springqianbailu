package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.interfaces.xiaomi.HomeAppinfoService;
import com.open.springqianbailu.interfaces.xiaomi.viewtype.ItemService;
import com.open.springqianbailu.model.HomeAppInfo;
import com.open.springqianbailu.model.tab.Body;
import com.open.springqianbailu.model.tab.ViewTypeBean;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/home")
public class HomeTabController extends AbsController {

    @Resource
    private HomeAppinfoService homeAppinfoService;

    @Resource
    private ItemService itemService;


    @ApiOperation(value = "getAppInfo", notes = "获取home顶部tab菜单")
    @RequestMapping(value = "/getAppInfo", method = RequestMethod.GET)
    @ResponseBody
    public Result getAppInfo() {
        HomeAppInfo homeAppInfo = new HomeAppInfo();
        homeAppInfo.setTabs(homeAppinfoService.selectAll());
        return Result.success(homeAppInfo);
    }


    @ApiOperation(value = "getHomeBanner", notes = "根据viewType 获取home banner \"gallery\"")
    @ApiImplicitParam(name = "viewType", value = "viewType", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/getHomeBanner/{viewType}", method = RequestMethod.GET)
    @ResponseBody
    public Result getHomeBanner(@PathVariable String viewType) {
        ViewTypeBean viewTypeBean = new ViewTypeBean();
        Body body = new Body();
        body.setItems(itemService.selectByViewType(viewType));
        viewTypeBean.setBody(body);
        return Result.success(viewTypeBean);
    }
}
