package com.open.springqianbailu.service.gallery;

import com.open.springqianbailu.model.table.gallery.GalleryImage;

import java.util.HashMap;
import java.util.List;

public interface GalleryImageService {
    int insert(GalleryImage record);

    List<GalleryImage> selectImage(String href, String page);
}