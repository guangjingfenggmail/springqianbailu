package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.Menu;
import com.open.springqianbailu.redis.RedisUtil;
import com.open.springqianbailu.service.MenuSevice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_MENU_LIST_KEY;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    static Logger logger = LoggerFactory.getLogger(MenuController.class.getSimpleName());
    @Resource
    private MenuSevice menuSevice;

    @Resource
    private RedisUtil redisUtil;


    @ApiOperation(value = "getMenus", notes = "获取所有父菜单")
    @RequestMapping(value = "/getMenus", method = RequestMethod.GET)
    @ResponseBody
    public Result getMenus() {
        List<Menu> list = (List<Menu>) redisUtil.get(REDIS_MENU_LIST_KEY);
        if (list == null || list.size()==0) {
            list = menuSevice.selectAll();
            redisUtil.set(REDIS_MENU_LIST_KEY,list,REDIS_EXPIRE_TIME);
        }
        Gson gson = new Gson();
        logger.info("MenuController"+ gson.toJson(list));
        return Result.success(list);
    }


    @ApiOperation(value = "addMenu", notes = "新增menu{\"title\":\"图片\",\"href\":\"113\",\"type\":0}")
    @ApiImplicitParam(name = "menu", value = "menu", required = true, dataType = "Menu", paramType = "body")
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    @ResponseBody
    public Result addMenu(@RequestBody Menu menu) {
        int result = this.menuSevice.insert(menu);
        return Result.success(result);
    }

}
