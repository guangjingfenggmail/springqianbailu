package com.open.springqianbailu.service.jsoup.novel;


import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.SubMenu;
import com.open.springqianbailu.model.novel.Novel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("jsoupNovelService")
public class JsoupNovelServiceImpl implements JsoupNovelService {

    @Resource
    private NovelMapper novelMapper;

    @Resource
    private SubMenuMapper subMenuMapper;

    @Override
    public void updateNovelList() {
        novelMapper.dropTable();
        novelMapper.createTable();
        List<SubMenu> subMenuList = subMenuMapper.selectByMenuId(1);
        for (SubMenu menu:subMenuList){
            List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref());
            novelMapper.insertBatch(list);
            break;
        }
    }
}
