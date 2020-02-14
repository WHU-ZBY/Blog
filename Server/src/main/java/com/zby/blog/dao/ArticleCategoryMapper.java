package com.zby.blog.dao;

import com.zby.blog.pojo.ArticleCategory;

public interface ArticleCategoryMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ArticleCategory record);

    ArticleCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ArticleCategory record);
}