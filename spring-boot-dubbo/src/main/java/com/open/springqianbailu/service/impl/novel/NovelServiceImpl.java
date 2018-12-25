package com.open.springqianbailu.service.impl.novel;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.model.table.novel.Novel;
import com.open.springqianbailu.rabbitmq.NovelSender;
import com.open.springqianbailu.service.novel.NovelService;
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
    @Resource
    private SubMenuMapper subMenuMapper;

    @Autowired
    private NovelSender novelSender;

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
        List<Novel> list = (List<Novel>) redisUtil.get(reqMap.toString());
        if (list==null || list.size()==0){
            list = novelMapper.selectByMenuId(reqMap);
            redisUtil.set(reqMap.toString(),list,REDIS_EXPIRE_TIME);
        }
        return novelMapper.selectByMenuId(reqMap);
    }

    @Override
    public void updateNovelList() {
        novelMapper.dropTable();
        novelMapper.createTable();
        List<SubMenu> subMenuList = subMenuMapper.selectByMenuId(1);
        for (SubMenu menu:subMenuList){
            List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref());
            novelMapper.insertBatch(list);
        }
    }

    @Override
    public int parseNovel(NovelMessage message) {
        novelSender.send(message);
        return 0;
    }
}
