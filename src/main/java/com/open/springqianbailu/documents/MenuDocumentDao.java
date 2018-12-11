package com.open.springqianbailu.documents;

import com.open.springqianbailu.model.Menu;
import com.open.springqianbailu.model.SubMenu;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MenuDocumentDao extends AbsDocumentDao {
    static Logger logger = LoggerFactory.getLogger(MenuDocumentDao.class.getSimpleName());

    public static List<Menu> parseMenus() {
        List<Menu> list = new ArrayList<>();
        logger.info("parseMenus start =====");

        try {
            Document doc = Jsoup.connect(DOMAIN+"/index.html")
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();

            if (doc != null) {
                Elements headElements = doc.select("li.nav-item");
                if (headElements != null && headElements.size() > 0) {
                    Menu menu;
                    for (int i = 0; i < headElements.size(); i++) {
                        menu = new Menu();
                        Element aElement = headElements.get(i).select("a").first();
                        try {
                            if (aElement != null) {
                                String title = aElement.text();
                                logger.info("i==" + i + ";title==" + title);
                                menu.setTitle(title);
                                menu.setType(i);

                                String href = aElement.attr("href");
                                logger.info("i==" + i + ";href==" + href);
                                href = href.replace(" ","").replace("javascript:void(0);","");
                                if (href==null || href.length()==0){
                                    href = DOMAIN;
                                }
                                if (!href.contains("https") && !href.contains("http")){
                                    href = "https:"+href;
                                }
                                menu.setHref(href);

                                list.add(menu);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.error("MenuDocumentDao", e);
        }

        logger.info("parseMenus end =====");
        return list;
    }


    public static List<SubMenu> parseSubMenus() {
        List<SubMenu> list = new ArrayList<>();
        logger.info("parseSubMenus start =====");

        try {
            Document doc = Jsoup.connect(DOMAIN+"/index.html")
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();

            if (doc != null) {
                Elements headElements = doc.select("li.nav-item");
                if (headElements != null && headElements.size() > 0) {
                    SubMenu menu;
                    for (int i = 0; i < headElements.size(); i++) {
                        Elements aElements = headElements.get(i).select("li");
                        if (aElements!=null && aElements.size()>0){
                            for(int j=0;j<aElements.size()-2;j++){
                                menu = new SubMenu();

                                try {
                                    Element aElement = aElements.get(j).select("a").first();
                                    if (aElement != null) {
                                        menu.setMenuId(i);

                                        String href = aElement.attr("href");
                                        href = href.replace(" ","").replace("javascript:void(0);","");
                                        if (href==null || href.length()==0){
                                            href = DOMAIN;
                                        }
                                        if (!href.contains("https") && !href.contains("http")){
                                            href = "https:"+href;
                                        }
                                        logger.info("i==" + i + ";j=="+j+";href==" + href);
                                        menu.setHref(href);
                                        menu.setUpdateTime(System.currentTimeMillis()+"");

                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                try {
                                    Element aElement = aElements.get(j).select("img").first();
                                    if (aElement != null) {
                                        String title = aElement.attr("alt");
                                        logger.info("i==" + i + ";j=="+j+ ";title==" + title);
                                        menu.setTitle(title);

                                        menu.setMenuName(headElements.get(i).select("span").first().text());

                                        String src = aElement.attr("data-src");
                                        if (!src.contains("https") && !src.contains("http")){
                                            src = "https:"+src;
                                        }
                                        logger.info("i==" + i + ";j=="+j+ ";src==" + src);
                                        menu.setSrc(src);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                try {
                                    Element aElement = aElements.get(j).select("p").first();
                                    if (aElement != null) {
                                        String price = aElement.text();
                                        logger.info("i==" + i + ";j=="+j+ ";price==" + price);
                                        menu.setPrice(price);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                list.add(menu);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.error("MenuDocumentDao", e);
        }

        logger.info("parseSubMenus end =====");
        return list;
    }
}
