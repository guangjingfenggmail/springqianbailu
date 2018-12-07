package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.SubMenu;
import com.open.springqianbailu.redis.RedisUtil;
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

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_SUBMENU_LIST_KEY;

@Controller
@RequestMapping(value = "/submenu")
public class SubMenuController extends AbsController{
    @Resource
    private SubMenuSevice subMenuSevice;

    @ApiOperation(value = "getSubMenus", notes = "根据父菜单id获取所有子菜单")
    @ApiImplicitParam(name = "menuId", value = "父菜单id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/getSubMenus/{menuId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getSubMenus(@PathVariable String menuId) {
        List<SubMenu> list = (List<SubMenu>) redisUtil.get(REDIS_SUBMENU_LIST_KEY+menuId);
        if (list==null || list.size()==0){
            list = subMenuSevice.selectByMenuId(Integer.parseInt(menuId));
            redisUtil.lSet(REDIS_SUBMENU_LIST_KEY+menuId,list,REDIS_EXPIRE_TIME);
        }
        Gson gson = new Gson();
        logger.info(TAG+"=="+gson.toJson(list));
        return Result.success(list);
    }
}
