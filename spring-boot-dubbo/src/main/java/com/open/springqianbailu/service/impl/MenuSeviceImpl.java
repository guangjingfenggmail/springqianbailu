package com.open.springqianbailu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.dao.SplashMapper;
import com.open.springqianbailu.dao.TabCfgTableMapper;
import com.open.springqianbailu.model.bean.AppStart;
import com.open.springqianbailu.model.bean.AppTabcfg;
import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.model.table.Splash;
import com.open.springqianbailu.model.table.TabCfgTable;
import com.open.springqianbailu.rest.XiaomiRestService;
import com.open.springqianbailu.service.MenuSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.rest.HomeTabRestService.APP_START;
import static com.open.springqianbailu.rest.HomeTabRestService.APP_TABCFG;


@Component
@Service(interfaceClass = MenuSevice.class) //dubbo的service，注入接口
public class MenuSeviceImpl  implements MenuSevice {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    public RedisUtil redisUtil;

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SplashMapper splashMapper;

    @Autowired
    private TabCfgTableMapper tabCfgTableMapper;

    @Override
    public int insert(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        return menuMapper.insert(menu);
    }

    @Override
    public int insertSelective(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        return menuMapper.insertSelective(menu);
    }

    @Override
    public List<Menu> selectAll() {
        List<Menu> list = (List<Menu>) redisUtil.get("MenuSevice"+"selectAll");
        if (list == null || list.size() == 0) {
            list = menuMapper.selectAll();
            redisUtil.set("MenuSevice"+"selectAll", list, REDIS_EXPIRE_TIME);
        }
        return list;
    }


    @Override
    public void updateById(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        menuMapper.updateById(menu);
    }

    @Override
    public void doTaskMenu(List<Menu> list) {
        if (list!=null && list.size()>0){
            menuMapper.dropTable();
            menuMapper.createTable();
            for (Menu menu : list) {
                menu.setUpdateTime(System.currentTimeMillis()+"");
            }
            menuMapper.insertBatch(list);
        }
    }

    @Override
    public AppStart appStart(HashMap<String, Object> map) {
        String resultStr = (String) redisUtil.get("appStart" + map.toString());
        Gson gson = new Gson();
        AppStart result = gson.fromJson(resultStr, AppStart.class);
        if (resultStr == null || resultStr.length() == 0) {
            resultStr = XiaomiRestService.responseEntity(map, restTemplate, APP_START).getBody();
            logger.info("appStart=====" + resultStr);
            redisUtil.set("appStart" + map.toString(), resultStr);
            result = gson.fromJson(resultStr, AppStart.class);

            Splash splash = result.data.splash;
            splashMapper.insert(splash);
        }
        return result;
    }


    @Override
    public AppTabcfg appTabcfg(HashMap<String, Object> map) {
        String resultStr = (String) redisUtil.get("appTabcfg" + map.toString());
        Gson gson = new Gson();
        AppTabcfg result = gson.fromJson(resultStr, AppTabcfg.class);
        if (resultStr == null || resultStr.length() == 0) {
            resultStr = XiaomiRestService.responseEntity(map, restTemplate, APP_TABCFG).getBody();
            logger.info("appTabcfg=====" + resultStr);
            redisUtil.set("appTabcfg" + map.toString(), resultStr);
            result = gson.fromJson(resultStr, AppTabcfg.class);

            List<TabCfgTable> list = result.data.getTab_config();
            tabCfgTableMapper.dropTable();
            tabCfgTableMapper.createTable();
            for (TabCfgTable bean : list) {
                tabCfgTableMapper.insert(bean);
            }
        }
        return result;
    }
}
