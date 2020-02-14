package com.zby.blog.dao;

import com.zby.blog.pojo.ArticlePicture;

public interface ArticlePictureMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ArticlePicture record);

    ArticlePicture selectByPrimaryKey(Long id);

}