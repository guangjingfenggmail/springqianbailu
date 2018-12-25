package com.open.springqianbailu.service.novel;


import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.novel.Novel;

import java.util.HashMap;
import java.util.List;

public interface NovelService {

    int insert(Novel novel);

    int insertSelective(Novel novel);

    List<Novel> selectByMenuId(HashMap map);

    public void updateNovelList();

    public int parseNovel(NovelMessage message);
}