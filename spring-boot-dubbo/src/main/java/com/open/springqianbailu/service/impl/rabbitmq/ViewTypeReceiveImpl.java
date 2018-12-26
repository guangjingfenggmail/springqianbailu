package com.open.springqianbailu.service.impl.rabbitmq;



import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.viewtype.ActionMapper;
import com.open.springqianbailu.dao.viewtype.ItemMapper;
import com.open.springqianbailu.dao.viewtype.ViewTypeBodyTableMapper;
import com.open.springqianbailu.dao.viewtype.ViewTypeTableMapper;
import com.open.springqianbailu.model.rabbitmq.Message;
import com.open.springqianbailu.model.table.viewtype.Action;
import com.open.springqianbailu.model.table.viewtype.Item;
import com.open.springqianbailu.model.table.viewtype.ViewTypeBodyTable;
import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;
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

    @Resource
    private ViewTypeTableMapper viewTypeTableMapper;

    @Resource
    private ViewTypeBodyTableMapper viewTypeBodyTableMapper;


    @RabbitListener(queues = RabbitMQConfig.QUEUENAME_VIEWTYPE_ITEM)//监听器监听指定的Queue
    public void processV(Message message) {
        logger.info(TAG+"======start handle message ====");
        List<ViewTypeTable>  list = (List<ViewTypeTable>) redisUtil.get(message.getParam());
        if (list==null || list.size()==0)
            return;
        for (ViewTypeTable table : list) {
            //viewtype
            if (table == null)
                continue;

            if (message.getParam().equals("ItemService"+"getHomeSections")){
                table.setTab_data_type("sections");
            }
            table.setTab_api(message.getParam2());
            viewTypeTableMapper.insert(table);

            //body
            ViewTypeBodyTable bodyTable = table.getBody();
            if (bodyTable == null)
                continue;
            bodyTable.setView_type_id(table.getId());
            viewTypeBodyTableMapper.insert(bodyTable);

            //item
            List<Item> items =  bodyTable.getItems();
            if (items==null || items.size()==0)
                continue;
            for (Item item:items){
                item.setView_type_id(table.getId());
                itemMapper.insert(item);

                Action action = item.getAction();
                action.setItem_id(item.getId());
                actionMapper.insert(action);
            }

        }
        logger.info(TAG+"======end handle message ====");
    }
}
