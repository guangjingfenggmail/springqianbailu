package com.open.springqianbailu.service.gallery;


import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.gallery.Gallery;

import java.util.HashMap;
import java.util.List;

public interface GalleryService {

    int insert(Gallery novel);

    int insertSelective(Gallery novel);

    List<Gallery> selectByMenuId(HashMap map);

    public void updateList();

    public int parseNovel(NovelMessage message);

    List<Gallery> selectByDate(HashMap map);
}
