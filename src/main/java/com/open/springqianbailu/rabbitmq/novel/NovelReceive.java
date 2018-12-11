//package com.open.springqianbailu.rabbitmq.novel;
//
//
//import com.google.gson.Gson;
//import com.open.springqianbailu.dao.SubMenuMapper;
//import com.open.springqianbailu.dao.novel.NovelMapper;
//import com.open.springqianbailu.documents.NovelDocmentDao;
//import com.open.springqianbailu.model.SubMenu;
//import com.open.springqianbailu.model.novel.Novel;
//import com.open.springqianbailu.rabbitmq.RabbitMQConfig;
//import com.open.springqianbailu.redis.RedisUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//import static com.open.springqianbailu.redis.ConstUitls.REDIS_NOVEL_LIST_KEY;
//
//@Component
//public class NovelReceive {
//    public  String TAG = getClass().getSimpleName();
//    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
//    @Resource
//    public RedisUtil redisUtil;
//
//    @Resource
//    private SubMenuMapper subMenuMapper;
//    @Resource
//    private NovelMapper novelMapper;
//
//    @RabbitListener(queues = RabbitMQConfig.QUEUENAME)//监听器监听指定的Queue
//    public void processC(NovelMessage message) {
//        Gson gson = new Gson();
//        logger.info("Receive:" + gson.toJson(message));
//        //获取submenu信息
//        SubMenu menu = subMenuMapper.selectById(Integer.parseInt(message.submenuId));
//        if (menu==null)
//            return;
//
//        List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref(),Integer.parseInt(message.pageNo));
//        redisUtil.set(REDIS_NOVEL_LIST_KEY+message.submenuId+message.pageNo,list);
//        //删除当前记录
//        novelMapper.deleteByPageNo(Integer.parseInt(message.pageNo));
//        if (list==null || list.size()==0)
//            return;
//        //入库
//        novelMapper.insertBatch(list);
//    }
//}
