package com.open.springqianbailu.model.table.novel;

import java.io.Serializable;

public class NovelPage implements Serializable {
    private Integer id;

    private Integer novel_artcile_id;

    private String href;

    private Integer page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNovel_artcile_id() {
        return novel_artcile_id;
    }

    public void setNovel_artcile_id(Integer novel_artcile_id) {
        this.novel_artcile_id = novel_artcile_id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}