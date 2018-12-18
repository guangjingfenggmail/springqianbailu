package com.open.springqianbailu.rabbitmq.xiaomi;


import com.google.gson.Gson;
import com.open.springqianbailu.dao.xiaomi.HomeAppinfoTableMapper;
import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;
import com.open.springqianbailu.rabbitmq.AbsReceive;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
import com.open.springqianbailu.rest.xiaomi.HomeTabRestService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HomeAppinfoReceive extends AbsReceive {
    @Resource
    private HomeAppinfoTableMapper homeAppinfoTableMapper;


    @RabbitListener(queues = RabbitMQConfig.QUEUENAME_APPINFO)//监听器监听指定的Queue
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
