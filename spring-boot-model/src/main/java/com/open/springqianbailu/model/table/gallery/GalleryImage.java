package com.open.springqianbailu.model.table.gallery;


import java.io.Serializable;

public class GalleryImage implements Serializable {
    private Integer id;

    private Integer gallery_id;

    private String src;

    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGallery_id() {
        return gallery_id;
    }

    public void setGallery_id(Integer gallery_id) {
        this.gallery_id = gallery_id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}