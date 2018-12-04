package com.open.springqianbailu.controller;


import com.open.springqianbailu.Result;
import com.open.springqianbailu.service.SubMenuSevice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/submenu")
public class SubMenuController {

    @Resource
    private SubMenuSevice subMenuSevice;


    @ApiOperation(value = "getSubMenus", notes = "根据父菜单id获取所有子菜单")
    @ApiImplicitParam(name = "menuId", value = "父菜单id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/getSubMenus/{menuId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getSubMenus(@PathVariable String menuId) {
        return Result.success(subMenuSevice.selectByMenuId(Integer.parseInt(menuId)));
    }
}
