package com.open.springqianbailu.rabbitmq.novel;


import com.google.gson.Gson;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
import com.open.springqianbailu.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class NovelReceive {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    public RedisUtil redisUtil;

    @Resource
    private NovelMapper novelMapper;

    @RabbitListener(queues = RabbitMQConfig.QUEUENAME)//监听器监听指定的Queue
    public void processC(NovelMessage message) {
        Gson gson = new Gson();
        logger.info("Receive:" + gson.toJson(message));
        //读取redis
        List<Novel> list = (List<Novel>) redisUtil.get(message.submenuId+message.pageNo);
        if (list==null || list.size()==0)
            return;
        //删除当前记录
        novelMapper.deleteByPageNo(Integer.parseInt(message.pageNo));
        //入库
        novelMapper.insertBatch(list);
    }
}
