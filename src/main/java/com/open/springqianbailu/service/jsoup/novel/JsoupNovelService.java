package com.open.springqianbailu.service.jsoup.novel;

import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.rabbitmq.novel.NovelMessage;

import java.util.List;

public interface JsoupNovelService {

    public void updateNovelList();

    public int parseNovel(NovelMessage message);

}
