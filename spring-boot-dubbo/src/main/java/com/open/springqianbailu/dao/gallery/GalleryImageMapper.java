package com.open.springqianbailu.dao.gallery;

import com.open.springqianbailu.model.table.gallery.GalleryImage;

import java.util.HashMap;
import java.util.List;

public interface GalleryImageMapper {
    int insert(GalleryImage record);

    void dropTable();

    void createTable();

    List<GalleryImage> selectImage(HashMap map);
}