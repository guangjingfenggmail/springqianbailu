package com.open.springqianbailu.model.table.novel;

import java.io.Serializable;
import java.util.List;

public class Novel implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private String href;

    private String updateTime;

    private Integer submenuId;

    private Integer pageNo;

    private List<NovelPage> pageList;

    private List<NovelArticle> articleList;

    private Integer page_id;

    public Integer getPage_id() {
        return page_id;
    }

    public void setPage_id(Integer page_id) {
        this.page_id = page_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public List<NovelPage> getPageList() {
        return pageList;
    }

    public void setPageList(List<NovelPage> pageList) {
        this.pageList = pageList;
    }

    public List<NovelArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<NovelArticle> articleList) {
        this.articleList = articleList;
    }
}