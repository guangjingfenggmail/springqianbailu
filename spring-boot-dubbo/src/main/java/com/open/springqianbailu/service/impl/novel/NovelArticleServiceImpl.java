package com.open.springqianbailu.service.impl.novel;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.novel.NovelArticleMapper;
import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.dao.novel.NovelPageMapper;
import com.open.springqianbailu.documents.NovelDocmentDao;
import com.open.springqianbailu.model.bean.jsoup.novel.ArticleBean;
import com.open.springqianbailu.model.table.novel.Novel;
import com.open.springqianbailu.model.table.novel.NovelArticle;
import com.open.springqianbailu.model.table.novel.NovelPage;
import com.open.springqianbailu.service.novel.NovelArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Component
@Service(interfaceClass = NovelArticleService.class) //dubbo的service，注入接口
public class NovelArticleServiceImpl implements NovelArticleService {
    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    public RedisUtil redisUtil;

    @Resource
    private NovelArticleMapper novelArticleMapper;

    @Resource
    private NovelMapper novelMapper;

    @Resource
    private NovelPageMapper novelPageMapper;

    @Override
    public int insert(NovelArticle record) {
        novelArticleMapper.insert(record);
        return 0;
    }

    @Override
    public List<NovelArticle> selectArticle(String href, String page) {
        List<NovelArticle> list = (List<NovelArticle>) redisUtil.get("NovelArticleService" + "getNovelArticle" + href + page);
        if (list == null || list.size() == 0) {
            HashMap map = new HashMap();
            map.put("href",href);
            map.put("page",page);
            list = novelArticleMapper.selectArticle(map);
            if (list == null || list.size() == 0) {
                ArticleBean articleBean = NovelDocmentDao.parseNovelArticleList(href, Integer.parseInt(page));
                if (articleBean != null) {
                    list = articleBean.getArticleList();

                    List<Novel> novelList = novelMapper.selectByHref(href);
                    if (novelList == null || novelList.size() == 0)
                        return list;

                    Novel novel = novelList.get(0);
                    if (list != null && list.size() > 0) {
                        for (NovelArticle article : list) {
                            article.setNovel_id(novel.getId());
                            novelArticleMapper.insert(article);
                            List<NovelPage> pageList = articleBean.getPageList();
                            if (pageList != null && pageList.size() > 0) {
                                for (NovelPage novelPage : pageList) {
                                    novelPage.setNovel_artcile_id(article.getId());
                                    novelPageMapper.insert(novelPage);
                                }
                            }
                        }
                    }
                }
            }
            redisUtil.set("NovelArticleService" + "getNovelArticle" + href + page, list);
        }
        return list;
    }
}