package com.zby.blog.dao;

import com.zby.blog.pojo.ArticleComment;

public interface ArticleCommentMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    ArticleComment selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ArticleComment record);
}