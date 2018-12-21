package com.open.springqianbailu.service.impl.rabbitmq;



import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.viewtype.ActionMapper;
import com.open.springqianbailu.dao.viewtype.ItemMapper;
import com.open.springqianbailu.model.rabbitmq.Message;
import com.open.springqianbailu.model.table.viewtype.Action;
import com.open.springqianbailu.model.table.viewtype.Item;
import com.open.springqianbailu.rabbitmq.RabbitMQConfig;

import com.open.springqianbailu.rest.HomeTabRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ViewTypeReceiveImpl   {

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private ActionMapper actionMapper;

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Resource
    public RedisUtil redisUtil;

    @Autowired
    public RestTemplate restTemplate;


    @RabbitListener(queues = RabbitMQConfig.QUEUENAME_VIEWTYPE_ITEM)//监听器监听指定的Queue
    public void processV(Message message) {
        logger.info(TAG+"======start handle message ====");
        List<Item>  list = HomeTabRestService.homeBanner(restTemplate, redisUtil);
        if (list==null || list.size()==0)
            return;

        itemMapper.dropTable();
        itemMapper.createTable();

        actionMapper.dropTable();
        actionMapper.createTable();
        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            item.setView_type(message.getParam());
            itemMapper.insert(item);

            Action action = item.getAction();
            action.setItem_id(i + 1);
            actionMapper.insert(action);
        }

        logger.info(TAG+"======end handle message ====");
    }
}
