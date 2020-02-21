package com.zby.blog.dao;

import com.zby.blog.pojo.ArticleContent;

public interface ArticleContentMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ArticleContent record);

    ArticleContent selectByPrimaryKey(int articleId);

    int updateByPrimaryKey(ArticleContent record);
}