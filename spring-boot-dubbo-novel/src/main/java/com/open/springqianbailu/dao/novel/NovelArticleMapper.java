package com.open.springqianbailu.dao.novel;

import com.open.springqianbailu.model.table.novel.NovelArticle;

import java.util.HashMap;
import java.util.List;

public interface NovelArticleMapper {
    int insert(NovelArticle record);

    int insertSelective(NovelArticle record);

    void dropTable();

    void createTable();

    List<NovelArticle> selectArticle(HashMap map);

    List<NovelArticle> selectById(HashMap map);
}