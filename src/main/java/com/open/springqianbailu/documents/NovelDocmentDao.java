package com.open.springqianbailu.documents;

import com.open.springqianbailu.model.novel.Novel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class NovelDocmentDao extends AbsDocumentDao {
    static Logger logger = LoggerFactory.getLogger(NovelDocmentDao.class.getSimpleName());

    public static List<Novel> parseNovelList(int id,String
                                              href) {
        logger.info("parseNovelList start =====");
        List<Novel> list = new ArrayList<>();
        href = DOMAIN + href;
        try {
            Document doc = Jsoup.connect(href)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();
            if (doc != null) {
                Element divElement = doc.select("div.channel").first();
                if (divElement != null) {
                    Elements liElements = divElement.select("ul").first().select("li");
                    if (liElements != null && liElements.size() > 0) {
                        Novel novel;
                        for (int i = 0; i < liElements.size(); i++) {
                            novel = new Novel();
                            Element aElement = liElements.get(i).select("a").first();
                            try {
                                if (aElement != null) {
                                    String title = aElement.text();
                                    logger.info("i==" + i + ";title==" + title);
                                    novel.setTitle(title);
                                    novel.setContent(title);

                                    String hrefa = aElement.attr("href");
                                    logger.info("i==" + i + ";hrefa==" + hrefa);
                                    if (hrefa == null || hrefa.length() == 0) {
                                        hrefa = href;
                                    }
                                    novel.setHref(hrefa);
                                    novel.setUpdateTime(System.currentTimeMillis() + "");
                                    novel.setSubmenuId(id);

                                    try {
                                        Element pageElement = divElement.select("div.pagination").first();
                                        String page = pageElement.select("a").get(1).text();
                                        novel.setPageNo(Integer.parseInt(page));
                                    } catch (Exception e) {
                                        logger.error("NovelDocmentDao", e);
                                    }

                                    list.add(novel);

                                }
                            } catch (Exception e) {
                                logger.error("NovelDocmentDao", e);
                            }
                        }
                    }
                }

            }

        } catch (Exception e) {
            logger.error("NovelDocmentDao", e);
        }
        logger.info("parseNovelList end =====");
        return list;
    }
}
