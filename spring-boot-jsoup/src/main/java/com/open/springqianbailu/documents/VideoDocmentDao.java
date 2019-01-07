package com.open.springqianbailu.documents;

import com.open.springqianbailu.model.table.video.Video;
import com.open.springqianbailu.model.table.video.VideoSource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class VideoDocmentDao extends AbsDocumentDao {
    static Logger logger = LoggerFactory.getLogger(VideoDocmentDao.class.getSimpleName());

    public static List<Video> parseList(int id, String href) {
        logger.info("parseList start =====");
        List<Video> list = new ArrayList<Video>();
        href = DOMAIN + href;
        logger.info("parseList href =====" + href);
        try {
            Document doc = Jsoup.connect(href)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();
            if (doc != null) {
                Elements liElements = doc.select("a.thumb-link");
                if (liElements != null && liElements.size() > 0) {
                    Video novel;
                    for (int i = 0; i < liElements.size(); i++) {
                        novel = new Video();
                        //<div>
                        //<a href="/AV/toupaizipai/2018/0724/906232.html" title="Ground fuck young woman" clickitem="52203" class="thumb-link" target="_blank"><img class="" alt="Ground fuck young woman" src="http://ckplayer.988aiai.com/media/videos/tmb/2740/default.jpg" height="180" width="125" />
                        //<span class="thumb-text">Ground fuck young woman</span>
                        //<span class="border"></span></a>
                        //<!--<span class="icon-hd"></span>--><span class="time">2018-07-24</span>
                        //</div>
                        Element aElement = liElements.get(i).select("a").first();
                        try {
                            if (aElement != null) {
                                String title = aElement.attr("title");
                                logger.info("i==" + i + ";title==" + title);
                                novel.setTitle(title);

                                String hrefa = aElement.attr("href");
                                logger.info("i==" + i + ";hrefa==" + hrefa);
                                if (hrefa == null || hrefa.length() == 0) {
                                    hrefa = href;
                                }

                                String date = aElement.select("span").text();
                                logger.info("i==" + i + ";date==" + date);
                                novel.setCreateDate(date);

                                novel.setHref(hrefa);
                                novel.setCreateDate(System.currentTimeMillis() + "");
                                novel.setSubmenuId(id);
                                try {
                                    Element pageElement = doc.select("div.pagination").first();
                                    String page = pageElement.select("a").get(1).text();
                                    novel.setPageNo(Integer.parseInt(page));
                                } catch (Exception e) {
                                    logger.error("VideoDocmentDao", e);
                                }

                                try {
                                    String time = aElement.parent().select("span.time").first().text();
                                    logger.info("i==" + i + ";time==" + time);
                                    novel.setTime(time);

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                try {
                                    String src = aElement.select("img").first().attr("src");
                                    logger.info("i==" + i + ";src==" + src);
                                    novel.setSrc(src);

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                list.add(novel);
                            }
                        } catch (Exception e) {
                            logger.error("VideoDocmentDao", e);
                        }
                    }
                }

            }

        } catch (Exception e) {
            logger.error("VideoDocmentDao", e);
        }
        logger.info("parseList end =====");
        return list;
    }


    public static List<Video> parseList(int id, String
            href, int pageNo) {
        logger.info("parseList start =====");
        List<Video> list = new ArrayList<Video>();
        href = DOMAIN + href;
        logger.info("parseList href =====" + href);
        try {
            Document doc = Jsoup.connect(href)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();
            if (doc != null) {
                try {
                    Element pageElement = doc.select("div.pagination").first();
                    Elements aElements = pageElement.select("a");
                    if (aElements != null) {
                        for (int i = 0; i < aElements.size(); i++) {
                            Element pElement = aElements.get(i).select("a").first();
                            String page = pElement.text();
                            /**
                             * 		<div class="pagination"><ul><a href='list_29_1.html'>首页</a>
                             * <a href='list_29_1.html'>上一页</a>
                             * <a href='list_29_1.html'>1</a>
                             * <a>2</a>
                             * <a href='list_29_3.html'>3</a>
                             * <a href='list_29_4.html'>4</a>
                             * <a href='list_29_5.html'>5</a>
                             * <a href='list_29_6.html'>6</a>
                             * <a href='list_29_7.html'>7</a>
                             * <a href='list_29_8.html'>8</a>
                             * <a href='list_29_9.html'>9</a>
                             * <a href='list_29_10.html'>10</a>
                             * <a href='list_29_11.html'>11</a>
                             * <a href='list_29_3.html'>下一页</a>
                             * <a href='list_29_38.html'>末页</a>
                             * </ul></div>
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
                    logger.error("VideoDocmentDao", e);
                }

                logger.info("parseList href =====" + href + ";pageNo==" + pageNo);
                doc = Jsoup.connect(href)
                        .header("User-Agent",
                                USER_AGENT)
                        .timeout(TIMEOUT)
                        .get();
                if (doc != null) {
                    Elements liElements = doc.select("a.thumb-link");
                    if (liElements != null && liElements.size() > 0) {
                        Video novel;
                        for (int i = 0; i < liElements.size(); i++) {
                            novel = new Video();
                            Element aElement = liElements.get(i).select("a").first();
                            try {
                                if (aElement != null) {
                                    String title = aElement.attr("title");
                                    logger.info("i==" + i + ";title==" + title);
                                    novel.setTitle(title);

                                    String hrefa = aElement.attr("href");
                                    logger.info("i==" + i + ";hrefa==" + hrefa);
                                    if (hrefa == null || hrefa.length() == 0) {
                                        hrefa = href;
                                    }
                                    novel.setHref(hrefa);

                                    novel.setCreateDate(System.currentTimeMillis() + "");
                                    novel.setSubmenuId(id);
                                    novel.setPageNo(pageNo);

                                    try {
                                        String time = aElement.parent().select("span.time").first().text();
                                        logger.info("i==" + i + ";time==" + time);
                                        novel.setTime(time);

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    try {
                                        String src = aElement.select("img").first().attr("src");
                                        logger.info("i==" + i + ";src==" + src);
                                        novel.setSrc(src);

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    list.add(novel);
                                }
                            } catch (Exception e) {
                                logger.error("VideoDocmentDao", e);
                            }
                        }
                    }
                }


            }

        } catch (Exception e) {
            logger.error("VideoDocmentDao", e);
        }
        logger.info("parseList end =====");
        return list;
    }


    public static VideoSource parseVideoSource(String href) {
        logger.info("parseVideoSource start =====");
        VideoSource articleBean = new VideoSource();
        String href1 = DOMAIN + href;
        logger.info("parseVideoSource href =====" + href1);
        try {
            Document doc = Jsoup.connect(href1)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();
            if (doc != null) {
                Element articleElement = doc.select("video.video-js").first();
                if (articleElement != null) {
                    try {
                        Element spanElement = doc.select("span.cat_pos_l").first();
                        String title = spanElement.text();
                        logger.info("title==" + title);
                        articleBean.setTitle(title);
                    } catch (Exception e) {
                        logger.error("VideoDocmentDao", e);
                    }

                    try {
                        Element spanElement = articleElement.select("video").first();
                        String img = spanElement.attr("poster");
                        logger.info("img==" + img);
                        articleBean.setImg(img);
                    } catch (Exception e) {
                        logger.error("VideoDocmentDao", e);
                    }

                    try {
                        Element imgElement = doc.select("source").first();
                        if (imgElement != null) {
                            String src = imgElement.attr("src");
                            logger.info("src==" + src);
                            articleBean.setSrc(src);

                            String type = imgElement.attr("type");
                            logger.info("type==" + type);
                            articleBean.setType(type);
                        }
                    } catch (Exception e) {
                        logger.error("VideoDocmentDao", e);
                    }
                }
            }

        } catch (
                Exception e) {
            logger.error("VideoDocmentDao", e);
        }
        logger.info("parseVideoSource end =====");
        return articleBean;
    }
}
