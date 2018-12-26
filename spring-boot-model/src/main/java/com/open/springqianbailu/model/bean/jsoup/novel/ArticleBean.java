package com.open.springqianbailu.model.bean.jsoup.novel;

import com.open.springqianbailu.model.table.novel.NovelArticle;
import com.open.springqianbailu.model.table.novel.NovelPage;

import java.io.Serializable;
import java.util.List;

public class ArticleBean implements Serializable {
    private List<NovelArticle> articleList;
    private List<NovelPage> pageList;

    public List<NovelArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<NovelArticle> articleList) {
        this.articleList = articleList;
    }

    public List<NovelPage> getPageList() {
        return pageList;
    }

    public void setPageList(List<NovelPage> pageList) {
        this.pageList = pageList;
    }
}
