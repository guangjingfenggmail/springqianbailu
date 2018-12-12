package com.open.springqianbailu.service;

import com.google.gson.Gson;
import com.open.springqianbailu.dao.MenuMapper;
import com.open.springqianbailu.interfaces.MenuSevice;
import com.open.springqianbailu.model.AppStart;
import com.open.springqianbailu.model.Menu;
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
import static com.open.springqianbailu.rest.RestApi.APP_START;


@Service("menuSevice")
public class MenuSeviceImpl extends AbsServiceImpl implements MenuSevice {

    @Resource
    private MenuMapper menuMapper;

    @Autowired
    private RestTemplate restTemplate;

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
            HttpHeaders headers = new HttpHeaders();
            headers.add("Device-Id", "ffffffff-ef26-54fa-9042-d26b0033c587");
            headers.add("Mishop-Client-Id", "180100031052");
            MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
            for (String key : map.keySet()) {
                postParameters.add(key, map.get(key).toString());
            }

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
                    postParameters, headers);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                    APP_START,
                    requestEntity,
                    String.class);
            resultStr = responseEntity.getBody();
            redisUtil.set(map.toString(), resultStr);
            result = gson.fromJson(resultStr, AppStart.class);
        }
        return result;
    }
}
