package com.open.springqianbailu.dao.novel;

import com.open.springqianbailu.model.table.novel.NovelPage;

public interface NovelPageMapper {
    int insert(NovelPage record);

    int insertSelective(NovelPage record);

    void dropTable();

    void createTable();
}