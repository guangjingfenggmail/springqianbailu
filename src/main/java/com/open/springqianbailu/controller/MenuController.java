package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.service.MenuSevice;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
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
}
