package com.open.springqianbailu.documents;

import com.open.springqianbailu.model.table.Menu;
import com.open.springqianbailu.model.table.Slider;
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
        List<SubMenu> list = new ArrayList<SubMenu>();
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


    public static List<Slider> parseSlider() {
        List<Slider> list = new ArrayList<Slider>();
        logger.info("parseSlider start =====");

        try {
            Document doc = Jsoup.connect(DOMAIN+"/index.html")
                    .header("User-Agent",
                            USER_AGENT)
                    .timeout(TIMEOUT)
                    .get();

            if (doc != null) {
                Elements headElements = doc.select("div.home-hero-slider").select("div.exposure");
                if (headElements != null && headElements.size() > 0) {
                    Slider slider;
                    for (int i = 0; i < headElements.size(); i++) {
                        slider = new Slider();
                        Element aElement = headElements.get(i).select("a").first();
                        try {
                            if (aElement != null) {
                                String log_code = aElement.attr("log_code");
                                logger.info("i==" + i + ";log_code==" + log_code);
                                slider.setLog_code(log_code);

                                String href = aElement.attr("href");
                                logger.info("i==" + i + ";href==" + href);
                                href = href.replace(" ","").replace("javascript:void(0);","");
                                if (href==null || href.length()==0){
                                    href = DOMAIN;
                                }
                                if (!href.contains("https") && !href.contains("http")){
                                    href = "https:"+href;
                                }
                                slider.setHref(href);

                                try {
                                    Element imgElement = headElements.get(i).select("img").first();
                                    if (imgElement!=null){
                                        String src = imgElement.attr("src");
                                        String srcset = imgElement.attr("srcset");
                                        slider.setSrc(src);
                                        slider.setSrcset(srcset);

                                        logger.info("i==" + i + ";src==" + src+";srcset=="+srcset);
                                    }else {
                                        String dataSet = headElements.get(i).attr("data-bg-set");
                                        //{'img':'//i1.mifile.cn/a4/xmad_15441768160624_QFmsJ.jpg','imgHd':'//i1.mifile.cn/a4/xmad_15441768194479_pKEuf.jpg'}
                                        dataSet = dataSet.replace("{'img':'","").replace("','imgHd':'",",").replace("'}","");
                                        logger.info("i==" + i + ";dataSet==" + dataSet);

                                        String[] split =  dataSet.split(",");
                                        String src = split[0];
                                        String srcset = split[0];
                                        slider.setSrc(src);
                                        slider.setSrcset(srcset);

                                        logger.info("i==" + i + ";src==" + src+";srcset=="+srcset);
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                list.add(slider);
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

        logger.info("parseSlider end =====");
        return list;
    }



}
