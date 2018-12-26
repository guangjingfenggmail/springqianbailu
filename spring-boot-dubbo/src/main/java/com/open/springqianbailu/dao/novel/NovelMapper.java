package com.open.springqianbailu.dao.novel;


import com.open.springqianbailu.model.table.novel.Novel;

import java.util.HashMap;
import java.util.List;

public interface NovelMapper   {
    int insert(Novel novel);

    int insertSelective(Novel novel);

    List<Novel> selectByMenuId(HashMap map);

    List<Novel> selectByHref(String href);

    int insertBatch(List<Novel> menu);

    void deleteByPageNo(int pageNo);

    void dropTable();

    void createTable();
}