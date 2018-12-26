package com.open.springqianbailu.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.model.bean.HomeRestAppInfo;
import com.open.springqianbailu.model.bean.tab.HomeSections;
import com.open.springqianbailu.model.table.HomeAppinfoTable;
import com.open.springqianbailu.model.table.viewtype.Item;
import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeTabRestService extends XiaomiRestService {

    /***首页顶部tab菜单**/
    public static String HOME_APPINFO = API + "/v1/home/appInfov2";

    /****启动splash*/
    public static String APP_START = API + "/v1/app/start";

    /****main tab配置*/
    public static String APP_TABCFG = API + "/v1/app/tabCfg";


    public static List<HomeAppinfoTable> homeAppInfo(RestTemplate restTemplate, RedisUtil redisUtil) {
        List<HomeAppinfoTable> list = new ArrayList<HomeAppinfoTable>();
        String resultStr = (String) redisUtil.get("HomeTabRestService" + "homeAppInfo");
        if (resultStr == null || resultStr.length() == 0) {
            resultStr = responseEntity(new HashMap<String, Object>(), restTemplate, HOME_APPINFO).getBody();
            redisUtil.set("HomeTabRestService" + "homeAppInfo", resultStr);
        }
        Gson gson = new Gson();
        HomeRestAppInfo result = gson.fromJson(resultStr, HomeRestAppInfo.class);
        list = result.data.getTabs();
        return list;
    }


    public static List<ViewTypeTable> viewTypeHeads(RestTemplate restTemplate, RedisUtil redisUtil) {
        List<ViewTypeTable> list = new ArrayList<ViewTypeTable>();
        String resultStr = (String) redisUtil.get("HomeTabRestService" + "homeAppInfo");
        if (resultStr == null || resultStr.length() == 0) {
            resultStr = responseEntity(new HashMap<String, Object>(), restTemplate, HOME_APPINFO).getBody();
            redisUtil.set("HomeTabRestService" + "homeAppInfo", resultStr);
        }

        JSONObject object = JSON.parseObject(resultStr);
        if (object == null)
            return list;
        JSONObject dataObject = object.getJSONObject("data");
        if (dataObject == null)
            return list;

        JSONArray tabsArray = dataObject.getJSONArray("tabs");
        if (tabsArray == null || tabsArray.size() == 0)
            return list;

        JSONObject appInfoObject = tabsArray.getJSONObject(0);
        if (appInfoObject == null)
            return list;

        JSONObject tabDataObject = appInfoObject.getJSONObject("tab_data");
        if (tabDataObject == null)
            return list;

        JSONObject headerObject = tabDataObject.getJSONObject("header");

        Gson gson = new Gson();
        ViewTypeTable bean = gson.fromJson(headerObject.toJSONString(), ViewTypeTable.class);
        if (bean == null || bean.getBody() == null || bean.getBody().getItems() == null)
            return list;
        bean.setTab_data_type("header");
        list.add(bean);
        return list;
    }

    public static List<ViewTypeTable> homeSections(RestTemplate restTemplate, RedisUtil redisUtil) {
        List<ViewTypeTable> list = new ArrayList<ViewTypeTable>();
        String resultStr = (String) redisUtil.get("HomeTabRestService" + "homeSections");
        if (resultStr == null || resultStr.length() == 0) {
            resultStr = responseEntity(new HashMap<String, Object>(), restTemplate, HOME_APPINFO).getBody();
            redisUtil.set("HomeTabRestService" + "homeSections", resultStr);
        }

        JSONObject object = JSON.parseObject(resultStr);
        if (object == null)
            return list;
        JSONObject dataObject = object.getJSONObject("data");
        if (dataObject == null)
            return list;

        JSONArray tabsArray = dataObject.getJSONArray("tabs");
        if (tabsArray == null || tabsArray.size() == 0)
            return list;

        JSONObject appInfoObject = tabsArray.getJSONObject(0);
        if (appInfoObject == null)
            return list;

        JSONObject tabDataObject = appInfoObject.getJSONObject("tab_data");
        if (tabDataObject == null)
            return list;

//        JSONArray sectionsArray = tabDataObject.getJSONArray("sections");

        Gson gson = new Gson();
        HomeSections bean = gson.fromJson(tabDataObject.toJSONString(), HomeSections.class);
        if (bean == null || bean.getSections() == null || bean.getSections().size() == 0)
            return list;

        return bean.getSections();
    }
}
