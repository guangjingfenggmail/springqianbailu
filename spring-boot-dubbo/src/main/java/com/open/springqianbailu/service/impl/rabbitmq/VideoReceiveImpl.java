package com.open.springqianbailu.service.impl.rabbitmq;


import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.video.VideoMapper;
import com.open.springqianbailu.documents.VideoDocmentDao;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.model.table.video.Video;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class VideoReceiveImpl {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    private SubMenuMapper subMenuMapper;
    @Resource
    private VideoMapper videoMapper;
    @Resource
    public RedisUtil redisUtil;

    @RabbitListener(queues = RabbitMQConfig.QUEUENAME_VIDEO)//监听器监听指定的Queue
    public void processC(NovelMessage message, Channel channel, Message msg) {
        try {
            Gson gson = new Gson();
            logger.info(TAG+"Receive:" + gson.toJson(message));
            //获取submenu信息
            SubMenu menu = subMenuMapper.selectById(Integer.parseInt(message.submenuId));
            if (menu==null)
                return;

            List<Video> list =  VideoDocmentDao.parseList(menu.getId(),menu.getHref(),Integer.parseInt(message.pageNo));
            redisUtil.set(TAG+"parseNovel"+message.submenuId+message.pageNo,list);
            //删除当前记录
            videoMapper.deleteByPageNo(Integer.parseInt(message.pageNo));
            if (list==null || list.size()==0)
                return;
            //入库
            videoMapper.insertBatch(list);

            //rabbitmq执行中出现异常无限报错解决
            channel.basicReject(msg.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e){
            logger.error(TAG,e);
        }
    }
}
