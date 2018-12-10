package com.open.springqianbailu.dao.novel;

import com.open.springqianbailu.dao.AbsMapper;
import com.open.springqianbailu.model.novel.Novel;

import java.util.HashMap;
import java.util.List;

public interface NovelMapper extends AbsMapper {
    int insert(Novel novel);

    int insertSelective(Novel novel);

    List<Novel> selectByMenuId(HashMap map);

    int insertBatch(List<Novel> menu);

    void deleteByPageNo(int pageNo);
}