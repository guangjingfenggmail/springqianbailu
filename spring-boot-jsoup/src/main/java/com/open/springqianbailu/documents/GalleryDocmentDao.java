package com.open.springqianbailu.documents;

import com.open.springqianbailu.model.bean.jsoup.novel.ArticleBean;
import com.open.springqianbailu.model.table.gallery.Gallery;
import com.open.springqianbailu.model.table.gallery.GalleryImage;
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


public class GalleryDocmentDao extends AbsDocumentDao {
    static Logger logger = LoggerFactory.getLogger(GalleryDocmentDao.class.getSimpleName());

    public static List<Gallery> parseList(int id, String href) {
        logger.info("parseList start =====");
        List<Gallery> list = new ArrayList<Gallery>();
        href = DOMAIN + href;
        logger.info("parseList href =====" + href);
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
                        Gallery novel;
                        for (int i = 0; i < liElements.size(); i++) {
                            novel = new Gallery();
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
                                        logger.error("GalleryDocmentDao", e);
                                    }
                                    list.add(novel);
                                }
                            } catch (Exception e) {
                                logger.error("GalleryDocmentDao", e);
                            }
                        }
                    }
                }

            }

        } catch (Exception e) {
            logger.error("GalleryDocmentDao", e);
        }
        logger.info("parseList end =====");
        return list;
    }


    public static List<Gallery> parseList(int id, String
            href, int pageNo) {
        logger.info("parseList start =====");
        List<Gallery> list = new ArrayList<Gallery>();
        href = DOMAIN + href;
        logger.info("parseList href =====" + href);
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
                                /**
                                 * 		<div class="pagination"><ul><a>首页</a>
                                 * <a>1</a>
                                 * <a href='list42.html'>2</a>
                                 * <a href='list43.html'>3</a>
                                 * <a href='list44.html'>4</a>
                                 * <a href='list45.html'>5</a>
                                 * <a href='list46.html'>6</a>
                                 * <a href='list47.html'>7</a>
                                 * <a href='list48.html'>8</a>
                                 * <a href='list49.html'>9</a>
                                 * <a href='list410.html'>10</a>
                                 * <a href='list411.html'>11</a>
                                 * <a href='list42.html'>下一页</a>
                                 * <a href='list4789.html'>末页</a>
                                 */
                                if (pageNo == 1) {
                                    if (page.endsWith("下一页")) {
//                                        href = href + pElement.attr("href");
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
                        logger.error("GalleryDocmentDao", e);
                    }

                    logger.info("parseList href =====" + href + ";pageNo==" + pageNo);
                    doc = Jsoup.connect(href)
                            .header("User-Agent",
                                    USER_AGENT)
                            .timeout(TIMEOUT)
                            .get();
                    if (doc != null) {
                        divElement = doc.select("div.channel").first();
                        Elements liElements = divElement.select("ul").first().select("li");
                        if (liElements != null && liElements.size() > 0) {
                            Gallery novel;
                            for (int i = 0; i < liElements.size(); i++) {
                                novel = new Gallery();
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
                                    logger.error("GalleryDocmentDao", e);
                                }
                            }
                        }
                    }

                }

            }

        } catch (Exception e) {
            logger.error("GalleryDocmentDao", e);
        }
        logger.info("parseList end =====");
        return list;
    }



    public static Gallery parseImageList(String href, int pageNo) {
        logger.info("parseImageList start =====");
        Gallery articleBean = new Gallery();
        List<GalleryImage> articleList = new ArrayList<GalleryImage>();
        String href1 = DOMAIN + href;
        logger.info("parseImageList href =====" + href1);
        try {
            Document doc = Jsoup.connect(href1)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();
            if (doc != null) {
                Element articleElement = doc.select("div.cat_pos").first();
                GalleryImage novel;
                if (articleElement != null) {
                    String title = "";
                    try {
                        Element spanElement = articleElement.select("span").first();
                        title = spanElement.text();
                        logger.info("title==" + title);
                    }catch (Exception e){
                        logger.error("GalleryDocmentDao", e);
                    }

                    try {
                        Elements imgElements = doc.select("div.pics").first().select("img");
                        if (imgElements!=null){
                            for (int i=0;i<imgElements.size();i++){
                                novel = new GalleryImage();
                                Element imgElement = imgElements.get(i);
                                String src = imgElement.attr("src");
                                logger.info("src==" + src);

                                novel.setSrc(src);
                                novel.setTitle(title);
                                articleList.add(novel);
                            }
                        }
                    }catch (Exception e){
                        logger.error("GalleryDocmentDao", e);
                    }
                }
            }

        } catch (
                Exception e) {
            logger.error("GalleryDocmentDao", e);
        }
        articleBean.setImageList(articleList);
        logger.info("parseImageList end =====");
        return articleBean;
    }
}
