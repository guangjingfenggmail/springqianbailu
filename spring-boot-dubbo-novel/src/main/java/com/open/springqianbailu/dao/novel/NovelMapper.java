package com.open.springqianbailu.dao.novel;


import com.open.springqianbailu.model.table.novel.Novel;

import java.util.HashMap;
import java.util.List;

public interface NovelMapper   {
    int insert(Novel novel);

    int insertSelective(Novel novel);

    List<Novel> selectByMenuId(HashMap map);

    List<Novel> selectByHref(HashMap map);

    int insertBatch(List<Novel> menu);

    void deleteByPageNo(HashMap map);

    void dropTable();

    void createTable();

    List<Novel> selectByDate(HashMap map);
}