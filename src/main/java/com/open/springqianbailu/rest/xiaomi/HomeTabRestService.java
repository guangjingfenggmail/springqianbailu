package com.open.springqianbailu.rest.xiaomi;

import com.google.gson.Gson;
import com.open.springqianbailu.model.rest.HomeRestAppInfo;
import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;
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
}
