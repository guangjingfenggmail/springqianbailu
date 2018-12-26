package com.open.springqianbailu.dao.novel;

import com.open.springqianbailu.model.table.novel.NovelArticle;

public interface NovelArticleMapper {
    int insert(NovelArticle record);

    int insertSelective(NovelArticle record);

    void dropTable();

    void createTable();
}