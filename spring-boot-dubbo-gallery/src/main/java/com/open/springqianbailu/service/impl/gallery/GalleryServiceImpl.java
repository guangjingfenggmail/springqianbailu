package com.open.springqianbailu.service.impl.gallery;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.gallery.GalleryMapper;
import com.open.springqianbailu.documents.GalleryDocmentDao;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.model.table.gallery.Gallery;
import com.open.springqianbailu.model.table.rabbitmq.RabbitMessage;
import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;
import com.open.springqianbailu.service.gallery.GalleryService;
import com.open.springqianbailu.service.impl.rabbitmq.sender.GallerySender;
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
@Service(interfaceClass = GalleryService.class) //dubbo的service，注入接口
public class GalleryServiceImpl implements GalleryService {
    @Resource
    public RedisUtil redisUtil;

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    private GalleryMapper galleryMapper;
    @Resource
    private SubMenuMapper subMenuMapper;

    @Autowired
    private GallerySender gallerySender;

    @Resource
    private RabbitMessageService rabbitMessageService;

    @Autowired
    private RabbitQueueService rabbitQueueService;

    @Override
    public int insert(Gallery novel) {
        return galleryMapper.insert(novel);
    }

    @Override
    public int insertSelective(Gallery novel) {
        return galleryMapper.insertSelective(novel);
    }

    @Override
    public List<Gallery> selectByMenuId(HashMap reqMap) {
        List<Gallery> list = (List<Gallery>) redisUtil.get(TAG+reqMap.toString());
        if (list==null || list.size()==0){
            list = galleryMapper.selectByMenuId(reqMap);
            redisUtil.set(TAG+reqMap.toString(),list,REDIS_EXPIRE_TIME);
        }
        return list;
    }

    @Override
    public void updateList() {
        galleryMapper.dropTable();
        galleryMapper.createTable();
        List<SubMenu> subMenuList = subMenuMapper.selectByMenuId(0);
        for (SubMenu menu:subMenuList){
            List<Gallery> list =  GalleryDocmentDao.parseList(menu.getId(),menu.getHref());
            galleryMapper.insertBatch(list);
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
        msg.setStatus(0);
        rabbitMessageService.insert(msg);

        RabbitQueue queue = new RabbitQueue();
        queue.setRabbit_mq_id(msg.getId());
        queue.setUuid(message.uuid);
        queue.setRoutingKey(message.routingKey);
        queue.setStatus(0);
        rabbitQueueService.insert(queue);

        message.id = msg.getId();
        gallerySender.send(message);
        return 0;
    }

    @Override
    public List<Gallery> selectByDate(HashMap map) {
        List<Gallery> list = (List<Gallery>) redisUtil.get(TAG+map.toString());
        if (list==null || list.size()==0){
            list = galleryMapper.selectByDate(map);
            redisUtil.set(TAG+map.toString(),list,REDIS_EXPIRE_TIME);
        }
        return list;
    }
}
