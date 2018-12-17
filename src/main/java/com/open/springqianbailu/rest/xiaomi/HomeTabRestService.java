package com.open.springqianbailu.rest.xiaomi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.open.springqianbailu.model.rest.HomeRestAppInfo;
import com.open.springqianbailu.model.tab.ViewTypeBean;
import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;
import com.open.springqianbailu.model.xiaomi.viewtype.Item;
import com.open.springqianbailu.redis.RedisUtil;
import com.open.springqianbailu.rest.XiaomiRestService;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.rest.RestApi.HOME_APPINFO;

public class HomeTabRestService extends XiaomiRestService {

    public static List<HomeAppinfoTable> homeAppInfo(RestTemplate restTemplate,RedisUtil redisUtil){
        List<HomeAppinfoTable> list = new ArrayList<>();
        String resultStr = (String) redisUtil.get("HomeTabRestService" + "homeAppInfo");
        if (resultStr==null || resultStr.length()==0){
            resultStr = responseEntity(new HashMap<>(), restTemplate,HOME_APPINFO).getBody();
            redisUtil.set("HomeTabRestService" + "homeAppInfo",resultStr);
        }
        Gson gson = new Gson();
        HomeRestAppInfo result = gson.fromJson(resultStr,HomeRestAppInfo.class);
        list =  result.data.getTabs();
        return list;
    }



    public static List<Item> homeBanner(RestTemplate restTemplate, RedisUtil redisUtil){
        List<Item> list = new ArrayList<>();
        String resultStr = (String) redisUtil.get("HomeTabRestService" + "homeAppInfo");
        if (resultStr==null && resultStr.length()==0){
            resultStr = responseEntity(new HashMap<>(), restTemplate,HOME_APPINFO).getBody();
            redisUtil.set("HomeTabRestService" + "homeAppInfo",resultStr);
        }

        JSONObject object = JSON.parseObject(resultStr);
        if (object==null)
            return list;
        JSONObject dataObject = object.getJSONObject("data");
        if (dataObject==null)
            return list;

        JSONArray tabsArray = dataObject.getJSONArray("tabs");
        if (tabsArray==null || tabsArray.size()==0)
            return list;

        JSONObject appInfoObject = tabsArray.getJSONObject(0);
        if (appInfoObject==null)
            return list;

        JSONObject tabDataObject = appInfoObject.getJSONObject("tab_data");
        if (tabDataObject==null)
            return list;

        JSONObject headerObject = tabDataObject.getJSONObject("header");

        Gson gson = new Gson();
        ViewTypeBean bean = gson.fromJson(headerObject.toJSONString(),ViewTypeBean.class);
        if (bean==null || bean.getBody()==null || bean.getBody().getItems()==null)
            return list;

        return bean.getBody().getItems();
    }

}
