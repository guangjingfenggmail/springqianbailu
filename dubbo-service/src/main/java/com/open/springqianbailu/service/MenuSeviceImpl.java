package com.open.springqianbailu.service;

import com.google.gson.Gson;
import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.interfaces.MenuSevice;
import com.open.springqianbailu.interfaces.xiaomi.SplashService;
import com.open.springqianbailu.interfaces.xiaomi.TabCfgTableService;
import com.open.springqianbailu.model.AppStart;
import com.open.springqianbailu.model.AppTabcfg;
import com.open.springqianbailu.model.Menu;
import com.open.springqianbailu.model.tab.SplashBean;
import com.open.springqianbailu.model.tab.TabConfigBean;
import com.open.springqianbailu.model.xiaomi.Splash;
import com.open.springqianbailu.model.xiaomi.TabCfgTable;
import com.open.springqianbailu.rest.XiaomiRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_MENU_LIST_KEY;
import static com.open.springqianbailu.rest.RestApi.APP_START;
import static com.open.springqianbailu.rest.RestApi.APP_TABCFG;


@Service
public class MenuSeviceImpl extends AbsServiceImpl implements MenuSevice {

    @Resource
    private MenuMapper menuMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private SplashService splashService;

    @Resource
    private TabCfgTableService tabCfgTableService;

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
        List<Menu> list = (List<Menu>) redisUtil.get(REDIS_MENU_LIST_KEY);
        if (list == null || list.size() == 0) {
            list = menuMapper.selectAll();
            redisUtil.set(REDIS_MENU_LIST_KEY, list, REDIS_EXPIRE_TIME);
        }
        return list;
    }


    @Override
    public void updateById(Menu menu) {
        menu.setUpdateTime(System.currentTimeMillis() + "");
        menuMapper.updateById(menu);
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

            Splash splash = new Splash();
            SplashBean bean = result.data.splash;

            splash = gson.fromJson(gson.toJson(bean), Splash.class);
            splash.setFullDisplayImgUrl(bean.full_display_img_url);
            splash.setSkipUrl(bean.skip_url);
            splashService.insert(splash);
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

            List<TabConfigBean> list = result.data.getTab_config();
            tabCfgTableService.dropTable();
            tabCfgTableService.createTable();
            for (TabConfigBean bean : list) {
                TabCfgTable tabCfgTable = new TabCfgTable();
                tabCfgTable = gson.fromJson(gson.toJson(bean), TabCfgTable.class);
                tabCfgTable.setIconNormal(bean.icon_normal);
                tabCfgTable.setIconSelected(bean.icon_selected);
                tabCfgTable.setTextColorNormal(bean.text_color_normal);
                tabCfgTable.setTextColorSelected(bean.text_color_selected);
                tabCfgTableService.insert(tabCfgTable);
            }
        }
        return result;
    }
}
