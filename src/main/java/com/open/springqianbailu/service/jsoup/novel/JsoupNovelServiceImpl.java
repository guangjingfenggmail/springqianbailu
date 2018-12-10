package com.open.springqianbailu.service.jsoup.novel;


import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.SubMenu;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.rabbitmq.novel.NovelMessage;
import com.open.springqianbailu.rabbitmq.novel.NovelSender;
import com.open.springqianbailu.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("jsoupNovelService")
public class JsoupNovelServiceImpl implements JsoupNovelService {

    @Resource
    private NovelMapper novelMapper;

    @Resource
    private SubMenuMapper subMenuMapper;


    @Autowired
    private NovelSender novelSender;

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
        SubMenu menu = subMenuMapper.selectById(Integer.parseInt(message.submenuId));
        if (menu!=null){
            novelSender.send(message, menu);
        }
        return 0;
    }


}
