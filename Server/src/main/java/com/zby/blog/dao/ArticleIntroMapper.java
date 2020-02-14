package com.zby.blog.dao;

import com.zby.blog.pojo.ArticleIntro;

import java.util.List;

public interface ArticleIntroMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleIntro record);

    ArticleIntro selectByPrimaryKey(Long id);

    List<ArticleIntro> getArticleIntroByUid(int uid);
}
