package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;
import com.open.springqianbailu.service.viewtype.ViewTypeTableService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/viewtype")
public class ViewTypeController {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Reference
    private ViewTypeTableService viewTypeTableService;


    @ApiOperation(value = "getHomeBanner", notes = "根据viewType 获取home banner \"gallery\"")
    @ApiImplicitParam(name = "viewType", value = "viewType", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/getHomeBanner/{viewType}", method = RequestMethod.GET)
    @ResponseBody
    public Result getHomeBanner(@PathVariable String viewType) {
        List<ViewTypeTable> list = viewTypeTableService.selectByViewType(viewType);
        if (list==null || list.size()==0)
            return Result.error(-1,"no data");

        return Result.success(list);
    }


    @ApiOperation(value = "homeSections", notes = "根据viewType 获取home header/sections")
    @RequestMapping(value = "/homeSections/{data_type}", method = RequestMethod.GET)
    @ResponseBody
    public Result homeSections(@PathVariable String data_type) {
        List<ViewTypeTable> list = viewTypeTableService.getHomeSections(data_type);
        if (list==null || list.size()==0){
            return Result.error(-1,"no data");
        }
        return Result.success(list);
    }


    @ApiOperation(value = "selectByViewType", notes = "根据viewType  gallery")
    @ApiImplicitParam(name = "viewType", value = "viewType", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/selectByViewType/{viewType}", method = RequestMethod.GET)
    @ResponseBody
    public Result selectByViewType(@PathVariable String viewType) {
        List<ViewTypeTable> list = viewTypeTableService.selectByViewType(viewType);
        if (list==null || list.size()==0)
            return Result.error(-1,"no data");

        return Result.success(list);
    }
}
