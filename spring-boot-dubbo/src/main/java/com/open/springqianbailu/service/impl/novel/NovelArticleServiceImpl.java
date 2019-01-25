package com.open.springqianbailu.service.impl.novel;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
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
import javax.swing.event.ListDataEvent;
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
            map.put("page",page);
            map.put("href",href);
            List<Novel> novelList = novelMapper.selectByHref(map);
            Gson gson = new Gson();
            logger.info(TAG+"novel=="+gson.toJson(novelList));
            if (novelList!=null && novelList.size()>0){
                Novel novel = novelList.get(0);
                map.put("novel_id",novel.getId());

                list = novel.getArticleList();
                List<NovelPage> pageList1 = novel.getPageList();
                if (list == null || list.size() == 0) {
                    if (pageList1!=null && pageList1.size()>0)
                        href = pageList1.get(0).getHref();

                    ArticleBean articleBean = NovelDocmentDao.parseNovelArticleList(href, Integer.parseInt(page));
                    if (articleBean != null) {
                        list = articleBean.getArticleList();
                        if (list != null && list.size() > 0) {
                            for (NovelArticle article : list) {
                                article.setNovel_id(novel.getId());
                                novelArticleMapper.insert(article);
                                List<NovelPage> pageList = articleBean.getPageList();
                                if (pageList != null && pageList.size() > 0) {
                                    if(page.equals("1")){
                                        novelPageMapper.dropTable();
                                        novelPageMapper.createTable();
                                        for (NovelPage novelPage : pageList) {
                                            novelPage.setNovel_id(novel.getId());
                                            novelPageMapper.insert(novelPage);
                                        }
                                    }
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