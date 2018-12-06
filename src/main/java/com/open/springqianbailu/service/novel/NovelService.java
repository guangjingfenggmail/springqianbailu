package com.open.springqianbailu.service.novel;

import com.open.springqianbailu.model.novel.Novel;

import java.util.HashMap;
import java.util.List;

public interface NovelService {

    int insert(Novel novel);

    int insertSelective(Novel novel);

    List<Novel> selectByMenuId(HashMap map);
}
