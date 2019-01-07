package com.open.springqianbailu.service.impl.rabbitmq.receive;


import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.model.table.novel.Novel;
import com.open.springqianbailu.model.table.rabbitmq.RabbitMessage;
import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;
import com.open.springqianbailu.rabbitmq.QueueConfig;
import com.open.springqianbailu.service.rabbitmq.RabbitMessageService;
import com.open.springqianbailu.service.rabbitmq.RabbitQueueService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Component
public class NovelReceiveImpl {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    private SubMenuMapper subMenuMapper;
    @Resource
    private NovelMapper novelMapper;
    @Resource
    public RedisUtil redisUtil;

    @Autowired
    private RabbitMessageService rabbitMessageService;

    @Autowired
    private RabbitQueueService rabbitQueueService;

    @RabbitListener(queues = QueueConfig.QUEUENAME_NOVEL)//监听器监听指定的Queue
    public void processC(NovelMessage message, Channel channel, Message msg)  throws Exception{
        try {

            Gson gson = new Gson();
            logger.info(TAG+" Receive:" + gson.toJson(message));

            HashMap map = new HashMap();
            map.put("uuid",message.uuid);
            map.put("status","2");
            List<RabbitMessage> messageList = rabbitMessageService.selectById(map);
            logger.info(TAG+" Receive:" + gson.toJson(messageList));


            //获取submenu信息
            SubMenu menu = subMenuMapper.selectById(Integer.parseInt(message.submenuId));
            if (menu==null)
                return;

            List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref(),Integer.parseInt(message.pageNo));
            redisUtil.set(message.method+message.submenuId+message.pageNo,list);
            //删除当前记录
            novelMapper.deleteByPageNo(Integer.parseInt(message.pageNo));
            if (list==null || list.size()==0)
                return;
            //入库
            novelMapper.insertBatch(list);

            RabbitQueue rabbitMessage = new RabbitQueue();
            rabbitMessage.setStatus(3);
            rabbitMessage.setUuid(message.uuid);
            rabbitMessage.setRabbit_mq_id(message.id);
            rabbitMessage.setRoutingKey(message.routingKey);
            rabbitQueueService.insert(rabbitMessage);
        } catch (Exception e){
            logger.error(TAG,e);
            if (msg.getMessageProperties().getRedelivered()) {
                RabbitQueue rabbitMessage = new RabbitQueue();
                rabbitMessage.setStatus(4);
                rabbitMessage.setUuid(msg.getMessageProperties().getCorrelationIdString());
                rabbitMessage.setRabbit_mq_id(message.id);
                rabbitMessage.setRoutingKey(message.routingKey);
                rabbitQueueService.insert(rabbitMessage);
                logger.error(TAG+" 消息已重复处理失败,拒绝再次接收...");
                channel.basicReject(msg.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
            } else {
                RabbitQueue rabbitMessage = new RabbitQueue();
                rabbitMessage.setStatus(-2);
                rabbitMessage.setUuid(msg.getMessageProperties().getCorrelationIdString());
                rabbitMessage.setRabbit_mq_id(message.id);
                rabbitMessage.setRoutingKey(message.routingKey);
                rabbitQueueService.insert(rabbitMessage);
                logger.error(TAG+" 消息即将再次返回队列处理...");
                channel.basicNack(msg.getMessageProperties().getDeliveryTag(), false, true); // requeue为是否重新回到队列
            }
        }
    }
}
