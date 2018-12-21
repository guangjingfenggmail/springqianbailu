package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.bean.HomeAppInfo;
import com.open.springqianbailu.model.bean.tab.Body;
import com.open.springqianbailu.model.bean.tab.ViewTypeBean;
import com.open.springqianbailu.service.HomeAppinfoService;
import com.open.springqianbailu.service.viewtype.ItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;


@Controller
@RequestMapping(value = "/home")
public class HomeTabController   {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Reference
    private HomeAppinfoService homeAppinfoService;

    @Reference
    private ItemService itemService;

    @ApiOperation(value = "getAppInfo", notes = "获取home顶部tab菜单")
    @RequestMapping(value = "/getAppInfo", method = RequestMethod.GET)
    @ResponseBody
    public Result getAppInfo() {
        HomeAppInfo homeAppInfo = new HomeAppInfo();
        homeAppInfo.setTabs(homeAppinfoService.selectAll());
        Gson gson = new Gson();
        logger.info(TAG+gson.toJson(homeAppInfo));
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
