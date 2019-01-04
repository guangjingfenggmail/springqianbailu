package com.open.springqianbailu.documents;

import com.open.springqianbailu.model.bean.jsoup.novel.ArticleBean;
import com.open.springqianbailu.model.table.novel.Novel;
import com.open.springqianbailu.model.table.novel.NovelArticle;
import com.open.springqianbailu.model.table.novel.NovelPage;
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

    public static List<Novel> parseNovelList(int id, String href) {
        logger.info("parseNovelList start =====");
        List<Novel> list = new ArrayList<Novel>();
        href = DOMAIN + href;
        logger.info("parseNovelList href =====" + href);
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
                            //<li><a href="/xs/995778.html" target="_blank"><span>2019-01-03</span>一直要好的女生</a></li>
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

                                    String date = aElement.select("span").text();
                                    logger.info("i==" + i + ";date==" + date);
                                    novel.setCreateDate(date);

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


    public static List<Novel> parseNovelList(int id, String
            href, int pageNo) {
        logger.info("parseNovelList start =====");
        List<Novel> list = new ArrayList<Novel>();
        href = DOMAIN + href;
        logger.info("parseNovelList href =====" + href);
        try {
            Document doc = Jsoup.connect(href)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();
            if (doc != null) {
                Element divElement = doc.select("div.channel").first();
                if (divElement != null) {
                    try {
                        Element pageElement = divElement.select("div.pagination").first();
                        Elements aElements = pageElement.select("a");
                        if (aElements != null) {
                            for (int i = 0; i < aElements.size(); i++) {
                                Element pElement = aElements.get(i).select("a").first();
                                String page = pElement.text();
                                if (pageNo == 1) {
                                    if (page.endsWith("下一页")) {
                                        href = href + pElement.attr("href");
                                        break;
                                    }
                                } else {
                                    page = page.replace("首页", "").replace("下一页", "").replace("末页", "");
                                    if (page.length() > 0 && pageNo == Integer.parseInt(page)) {
                                        href = href + pElement.attr("href");
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        logger.error("NovelDocmentDao", e);
                    }

                    logger.info("parseNovelList href =====" + href + ";pageNo==" + pageNo);
                    doc = Jsoup.connect(href)
                            .header("User-Agent",
                                    USER_AGENT)
                            .timeout(TIMEOUT)
                            .get();
                    if (doc != null) {
                        divElement = doc.select("div.channel").first();
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

                                        String date = aElement.select("span").text();
                                        logger.info("i==" + i + ";date==" + date);
                                        novel.setCreateDate(date);

                                        novel.setUpdateTime(System.currentTimeMillis() + "");
                                        novel.setSubmenuId(id);
                                        novel.setPageNo(pageNo);
                                        list.add(novel);
                                    }
                                } catch (Exception e) {
                                    logger.error("NovelDocmentDao", e);
                                }
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


    public static ArticleBean parseNovelArticleList(String href, int pageNo) {
        logger.info("parseNovelArticleList start =====");
        ArticleBean articleBean = new ArticleBean();
        List<NovelArticle> articleList = new ArrayList<NovelArticle>();
        List<NovelPage> pageList = new ArrayList<NovelPage>();
        String href1 = DOMAIN + href;
        logger.info("parseNovelArticleList href =====" + href1);
        try {
            Document doc = Jsoup.connect(href1)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();
            if (doc != null) {
                if (pageNo == 1) {
                    Element divElement = doc.select("div.pagination").first();
                    if (divElement != null) {
                        try {
                            /***
                             * <div class="pagination"><ul><a>共15页: </a><a href='#'>上一页</a><a href='#'>1</a><a href='885694_2.html'>2</a><a href='885694_3.html'>3</a><a href='885694_4.html'>4</a><a href='885694_5.html'>5</a><a href='885694_6.html'>6</a><a href='885694_7.html'>7</a><a href='885694_8.html'>8</a><a href='885694_9.html'>9</a><a href='885694_10.html'>10</a><a href='885694_11.html'>11</a><a href='885694_12.html'>12</a><a href='885694_13.html'>13</a><a href='885694_14.html'>14</a><a href='885694_15.html'>15</a><a href='885694_2.html'>下一页</a></ul></div>
                             */
                            Elements aElements = divElement.select("a");
                            if (aElements != null) {
                                NovelPage novelPage;
                                int index = 1;
                                for (int i = 0; i < aElements.size(); i++) {
                                    Element pElement = aElements.get(i).select("a").first();
                                    String page = pElement.text();
                                    if (page.contains("页:") || page.contains("共")|| page.contains("上一页")|| page.contains("下一页")) {
                                        continue;
                                    }
                                    // /xs/885694.html
                                    String hrefgg = href.replace(".html","");
                                    novelPage = new NovelPage();
                                    novelPage.setHref(hrefgg+"_"+index+".html");
                                    novelPage.setPage(index);
                                    pageList.add(novelPage);
                                    index++;
                                }
                            }
                        } catch (Exception e) {
                            logger.error("NovelDocmentDao", e);
                        }
                    }
                }

                Element articleElement = doc.select("div.content").first();
                NovelArticle novel;
                if (articleElement != null) {
                    novel = new NovelArticle();
                    String title = articleElement.text();
                    logger.info("title==" + title);
                    novel.setContent(title);
                    novel.setPage(pageNo);
                    novel.setHref(href1);
                    articleList.add(novel);
                }
            }

        } catch (
                Exception e) {
            logger.error("NovelDocmentDao", e);
        }
        articleBean.setArticleList(articleList);
        articleBean.setPageList(pageList);
        logger.info("parseNovelArticleList end =====");
        return articleBean;
    }
}
