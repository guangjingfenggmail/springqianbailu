package com.open.springqianbailu.dao.gallery;

import com.open.springqianbailu.model.table.gallery.Gallery;

import java.util.HashMap;
import java.util.List;

public interface GalleryMapper {
    int insert(Gallery record);

    int insertSelective(Gallery record);

    List<Gallery> selectByMenuId(HashMap map);

    List<Gallery> selectByHref(HashMap map);

    int insertBatch(List<Gallery> menu);

    void deleteByPageNo(int pageNo);

    void dropTable();

    void createTable();

    List<Gallery> selectByDate(HashMap map);
}