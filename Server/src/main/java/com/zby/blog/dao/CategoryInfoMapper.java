package com.zby.blog.dao;

import com.zby.blog.pojo.CategoryInfo;

public interface CategoryInfoMapper {


    Boolean deleteByPrimaryKey(Long id);

    boolean insert(CategoryInfo record);

    CategoryInfo selectByPrimaryKey(Long id);

    Boolean updateByPrimaryKey(long id,String name);

    CategoryInfo selectByName(String name);
}