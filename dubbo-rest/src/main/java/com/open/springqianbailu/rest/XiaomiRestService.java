package com.open.springqianbailu.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


public class XiaomiRestService {

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());


    public static ResponseEntity<String> responseEntity(HashMap<String, Object> map,RestTemplate restTemplate,String url){
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
                url,
                requestEntity,
                String.class);
        return responseEntity;
    }



}
