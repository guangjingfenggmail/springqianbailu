package com.open.springqianbailu.rabbitmq;


import com.open.springqianbailu.dao.xiaomi.viewtype.ActionMapper;
import com.open.springqianbailu.dao.xiaomi.viewtype.ItemMapper;
import com.open.springqianbailu.model.xiaomi.viewtype.Action;
import com.open.springqianbailu.model.xiaomi.viewtype.Item;
import com.open.springqianbailu.rest.xiaomi.HomeTabRestService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ViewTypeReceive extends AbsReceive {

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private ActionMapper actionMapper;


    @RabbitListener(queues = RabbitMQConfig.QUEUENAME_VIEWTYPE_ITEM)//监听器监听指定的Queue
    public void processV(Message message) {
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
    }
}
