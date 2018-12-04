package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.Menu;
import com.open.springqianbailu.service.MenuSevice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Resource
    private MenuSevice menuSevice;


    @ApiOperation(value = "getMenus", notes = "获取所有父菜单")
    @RequestMapping(value="/getMenus", method=RequestMethod.GET)
    @ResponseBody
    public Result getMenus(){
        return Result.success(menuSevice.selectAll());
    }


    @ApiOperation(value = "addMenu", notes = "新增menu{\"title\":\"图片\",\"href\":\"113\",\"type\":0}")
    @ApiImplicitParam(name = "menu", value = "menu", required = true,dataType = "Menu", paramType = "body")
    @RequestMapping(value="/addMenu", method=RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody Menu menu){
        int result =  this.menuSevice.insert(menu);
        return Result.success(result);
    }

}
