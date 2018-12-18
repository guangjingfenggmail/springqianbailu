package com.open.springqianbailu.rabbitmq.xiaomi;


import com.google.gson.Gson;
import com.open.springqianbailu.dao.xiaomi.HomeAppinfoTableMapper;
import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
import com.open.springqianbailu.redis.RedisUtil;
import com.open.springqianbailu.rest.xiaomi.HomeTabRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HomeAppinfoReceive {
    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    public RedisUtil redisUtil;

    @Resource
    private HomeAppinfoTableMapper homeAppinfoTableMapper;

    @Autowired
    private RestTemplate restTemplate;


    @RabbitListener(queues = RabbitMQConfig.QUEUENAME)//监听器监听指定的Queue
    public void processC(Message message) {
        Gson gson = new Gson();
        logger.info("Receive:" + gson.toJson(message));
        List<HomeAppinfoTable> list = HomeTabRestService.homeAppInfo(restTemplate,redisUtil);
        if (list!=null && list.size()>0) {
            homeAppinfoTableMapper.dropTable();
            homeAppinfoTableMapper.createTable();
            homeAppinfoTableMapper.insertBatch(list);
        }
    }
}
