package com.open.springqianbailu.service.impl.rabbitmq;


import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.HomeAppinfoTableMapper;
import com.open.springqianbailu.model.rabbitmq.Message;
import com.open.springqianbailu.model.table.HomeAppinfoTable;
import com.open.springqianbailu.rest.HomeTabRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.rabbitmq.QueueConfig.QUEUENAME_APPINFO;

@Component
public class HomeAppinfoReceiveImpl   {
    @Resource
    private HomeAppinfoTableMapper homeAppinfoTableMapper;

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    public RedisUtil redisUtil;

    @Autowired
    public RestTemplate restTemplate;

    @RabbitListener(queues =  QUEUENAME_APPINFO)//监听器监听指定的Queue
    public void processC(Message message) {
        Gson gson = new Gson();
        logger.info(TAG+"======start handle message ===="+ gson.toJson(message));
        List<HomeAppinfoTable> list = HomeTabRestService.homeAppInfo(restTemplate,redisUtil);
        if (list!=null && list.size()>0) {
            homeAppinfoTableMapper.dropTable();
            homeAppinfoTableMapper.createTable();
            homeAppinfoTableMapper.insertBatch(list);
        }
        logger.info(TAG+"======end handle message ====");
    }

}
