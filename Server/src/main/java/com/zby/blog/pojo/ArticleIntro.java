package com.zby.blog.pojo;

import java.util.Date;

public class ArticleIntro {
    private long id;
    private int articleId;
    private String intro;
    private int uid;
    private String title;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getArticle_id() {
        return articleId;
    }

    public void setArticle_id(int article_id) {
        this.articleId = article_id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
