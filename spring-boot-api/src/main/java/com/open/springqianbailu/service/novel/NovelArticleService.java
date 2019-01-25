package com.open.springqianbailu.service.novel;

import com.open.springqianbailu.model.table.novel.NovelArticle;

import java.util.List;

public interface NovelArticleService {
    int insert(NovelArticle record);

    List<NovelArticle> selectArticle(String href,String page);
}