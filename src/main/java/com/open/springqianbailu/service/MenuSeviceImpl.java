package com.open.springqianbailu.service;

import com.google.gson.Gson;
import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.interfaces.MenuSevice;
import com.open.springqianbailu.interfaces.xiaomi.SplashService;
import com.open.springqianbailu.model.AppStart;
import com.open.springqianbailu.model.Menu;
import com.open.springqianbailu.model.xiaomi.Splash;
import com.open.springqianbailu.rest.SplashRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_MENU_LIST_KEY;


@Service("menuSevice")
public class MenuSeviceImpl extends AbsServiceImpl implements MenuSevice {

    @Resource
    private MenuMapper menuMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private SplashService splashService;

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
        String resultStr = (String) redisUtil.get(map.toString());
        Gson gson = new Gson();
        AppStart result = gson.fromJson(resultStr, AppStart.class);
        if (resultStr == null || resultStr.length() == 0) {
            resultStr = SplashRestService.appStart(map,restTemplate).getBody();
            logger.info("appStart====="+resultStr);
            redisUtil.set(map.toString(), resultStr);
            result = gson.fromJson(resultStr, AppStart.class);

            Splash splash = new Splash();
            AppStart.AppStartModel.SplashBean bean =  result.data.splash;

            splash = gson.fromJson(gson.toJson(bean),Splash.class);
            splash.setFullDisplayImgUrl(bean.full_display_img_url);
            splash.setSkipUrl(bean.skip_url);
            splashService.insert(splash);
        }
        return result;
    }
}
