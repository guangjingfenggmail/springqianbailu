package com.open.springqianbailu.service.jsoup.novel;

public interface JsoupNovelService {

    public void updateNovelList();

    public int parseNovel(String submenuId, String pageNo);
}
