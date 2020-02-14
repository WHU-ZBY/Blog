package com.zby.blog.dao;

import com.zby.blog.pojo.ArticleInfo;

import java.util.List;

public interface ArticleInfoMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Long id);

    List<ArticleInfo> selectArticleByUid(int uid);
}