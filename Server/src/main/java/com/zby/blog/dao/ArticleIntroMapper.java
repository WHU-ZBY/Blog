package com.zby.blog.dao;

import com.zby.blog.pojo.ArticleIntro;

public interface ArticleIntroMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleIntro record);

    ArticleIntro selectByPrimaryKey(Long id);

}
