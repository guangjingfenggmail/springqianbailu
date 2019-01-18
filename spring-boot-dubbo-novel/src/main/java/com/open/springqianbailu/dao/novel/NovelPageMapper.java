package com.open.springqianbailu.dao.novel;

import com.open.springqianbailu.model.table.novel.NovelPage;

import java.util.HashMap;
import java.util.List;

public interface NovelPageMapper {
    int insert(NovelPage record);

    int insertSelective(NovelPage record);

    void dropTable();

    void createTable();

    List<NovelPage> selectById(HashMap map);
}