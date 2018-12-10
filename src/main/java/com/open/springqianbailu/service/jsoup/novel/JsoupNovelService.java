package com.open.springqianbailu.service.jsoup.novel;

import com.open.springqianbailu.rabbitmq.novel.NovelMessage;


public interface JsoupNovelService {

    public void updateNovelList();

    public int parseNovel(NovelMessage message);

}
