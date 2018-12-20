package com.open.springqianbailu.rest;

import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.model.bean.HomeRestAppInfo;
import com.open.springqianbailu.model.table.HomeAppinfoTable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeTabRestService extends XiaomiRestService {

    /***首页顶部tab菜单**/
    public static String HOME_APPINFO = API +"/v1/home/appInfov2";


    public static List<HomeAppinfoTable> homeAppInfo(RestTemplate restTemplate, RedisUtil redisUtil){
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




}
