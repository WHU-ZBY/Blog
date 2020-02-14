package com.zby.blog.pojo;

public class ArticleIntro {
    private long id;
    private int article_id;
    private String intro;
    private int uid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
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
}
