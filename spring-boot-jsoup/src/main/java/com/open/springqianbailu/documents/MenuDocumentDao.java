package com.open.springqianbailu.documents;

import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.model.table.SubMenu;
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
        List<Menu> list = new ArrayList<Menu>();
        logger.info("parseMenus start =====");

        try {
            Document doc = Jsoup.connect(DOMAIN)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();

            if (doc != null) {
                Elements headElements = doc.select("div.k_head-2a");
//                Elements headElements = doc.select("div.tabbar").first().select("a");
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
                                if (href==null || href.length()==0){
                                    href = DOMAIN;
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
        List<SubMenu> list = new ArrayList<SubMenu>();
        logger.info("parseSubMenus start =====");

        try {
            Document doc = Jsoup.connect(DOMAIN)
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();

            if (doc != null) {
                Elements headElements = doc.select("div.k_head-2a");
                if (headElements != null && headElements.size() > 0) {
                    SubMenu menu;
                    for (int i = 0; i < headElements.size(); i++) {
                        Elements aElements = headElements.get(i).select("a");
                        if (aElements!=null && aElements.size()>0){
                            for(int j=1;j<aElements.size();j++){
                                menu = new SubMenu();
                                Element aElement = aElements.get(j).select("a").first();
                                try {
                                    if (aElement != null) {
                                        String title = aElement.text();
                                        logger.info("i==" + i + ";title==" + title);
                                        menu.setTitle(title);
                                        menu.setMenuId(i);

                                        String href = aElement.attr("href");
                                        logger.info("i==" + i + ";href==" + href);
                                        menu.setHref(href);

                                        menu.setMenuName(headElements.get(i).select("a").first().text());
                                        menu.setUpdateTime(System.currentTimeMillis()+"");

                                        list.add(menu);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
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
