package com.open.springqianbailu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.service.SubMenuSevice;
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
@RequestMapping(value = "/submenu")
public class SubMenuController   {

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Reference
    private SubMenuSevice subMenuSevice;



    @ApiOperation(value = "getSubMenus", notes = "根据父菜单id获取所有子菜单")
    @ApiImplicitParam(name = "menuId", value = "父菜单id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/getSubMenus/{menuId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getSubMenus(@PathVariable String menuId) {
        List<SubMenu> list = subMenuSevice.selectByMenuId(Integer.parseInt(menuId));
        Gson gson = new Gson();
        logger.info(TAG + "==" + gson.toJson(list));
        return Result.success(list);
    }



}
