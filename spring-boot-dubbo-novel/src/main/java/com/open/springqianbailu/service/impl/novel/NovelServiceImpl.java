package com.open.springqianbailu.service.impl.novel;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.model.table.novel.Novel;
import com.open.springqianbailu.model.table.rabbitmq.RabbitMessage;
import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;
import com.open.springqianbailu.service.SubMenuSevice;
import com.open.springqianbailu.service.impl.rabbitmq.sender.NovelSender;
import com.open.springqianbailu.service.novel.NovelService;
import com.open.springqianbailu.service.rabbitmq.RabbitMessageService;
import com.open.springqianbailu.service.rabbitmq.RabbitQueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;


@Component
@Service(interfaceClass = NovelService.class) //dubbo的service，注入接口
public class NovelServiceImpl  implements NovelService {
    @Resource
    public RedisUtil redisUtil;

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    private NovelMapper novelMapper;
    @Reference
    private SubMenuSevice subMenuSevice;

    @Autowired
    private NovelSender novelSender;

    @Reference
    private RabbitMessageService rabbitMessageService;

    @Reference
    private RabbitQueueService rabbitQueueService;

    @Override
    public int insert(Novel novel) {
        return novelMapper.insert(novel);
    }

    @Override
    public int insertSelective(Novel novel) {
        return novelMapper.insertSelective(novel);
    }

    @Override
    public List<Novel> selectByMenuId(HashMap reqMap) {
        List<Novel> list = (List<Novel>) redisUtil.get(TAG+reqMap.toString());
        if (list==null || list.size()==0){
            list = novelMapper.selectByMenuId(reqMap);
            redisUtil.set(TAG+reqMap.toString(),list,REDIS_EXPIRE_TIME);
        }
        return list;
    }

    @Override
    public void updateNovelList() {
        novelMapper.dropTable();
        novelMapper.createTable();
        List<SubMenu> subMenuList = subMenuSevice.selectByMenuId(1);
        for (SubMenu menu:subMenuList){
            List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref());
            novelMapper.insertBatch(list);
        }
    }

    @Override
    public int parseNovel(NovelMessage message) {
        Gson gson = new Gson();
        RabbitMessage msg = new RabbitMessage();
        msg.setUuid(message.uuid);
        msg.setRoutingKey(message.routingKey);
        msg.setCreateTime(System.currentTimeMillis()+"");
        msg.setMessage(gson.toJson(message));
        msg = rabbitMessageService.insert(msg);

        RabbitQueue queue = new RabbitQueue();
        queue.setRabbit_mq_id(msg.getId());
        queue.setUuid(message.uuid);
        queue.setRoutingKey(message.routingKey);
        queue.setStatus(0);
        rabbitQueueService.insert(queue);

        message.id = msg.getId();
        novelSender.send(message);
        return 0;
    }

    @Override
    public List<Novel> selectByDate(HashMap map) {
        List<Novel> list = (List<Novel>) redisUtil.get(TAG+map.toString());
        if (list==null || list.size()==0){
            list = novelMapper.selectByDate(map);
            redisUtil.set(TAG+map.toString(),list,REDIS_EXPIRE_TIME);
        }
        return list;
    }

    @Override
    public int insertBatch(List<Novel> menu) {
        return novelMapper.insertBatch(menu);
    }

    @Override
    public void deleteByPageNo(int pageNo) {
        novelMapper.deleteByPageNo(pageNo);
    }
}
