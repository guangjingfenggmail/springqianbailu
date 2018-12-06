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
            List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref(),1);
            novelMapper.insertBatch(list);
            break;
        }
    }

    @Override
    public int parseNovel(String submenuId, String pageNo) {
        SubMenu menu = subMenuMapper.selectById(Integer.parseInt(submenuId));
        if (menu!=null){
            List<Novel> list =  NovelDocmentDao.parseNovelList(menu.getId(),menu.getHref(),Integer.parseInt(pageNo));
            novelMapper.insertBatch(list);
        }
        return 0;
    }
}
