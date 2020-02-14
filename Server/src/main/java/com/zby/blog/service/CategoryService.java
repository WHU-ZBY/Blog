package com.zby.blog.service;


import com.zby.blog.dao.CategoryInfoMapper;
import com.zby.blog.pojo.CategoryInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
//没有完成更改category的状态参数
@Service
public class CategoryService {
    @Autowired
    private CategoryInfoMapper categoryInfoMapper;


    @ApiOperation(value = "insertCategory",notes = "校验合格之后，将category插入到数据库中")
    public CategoryInfo insertCategory(String name)
    {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));

        Date create_by=day;
        Date modified_by=day;
        CategoryInfo categoryInfo = new CategoryInfo();

        categoryInfo.setName(name);
        categoryInfoMapper.insert(categoryInfo);
        return categoryInfo;

    }

    @ApiOperation(value = "deleteCategory",notes = "删除目录根据id")
    public Boolean deleteCategory(long id)
    {
        CategoryInfo categoryInfo = categoryInfoMapper.selectByPrimaryKey(id);
        if(categoryInfo!=null)
        {
            System.out.println("find this category!");
            categoryInfoMapper.deleteByPrimaryKey(id);
            System.out.println("delete this category!");
            return true;
        }
        else
        {
            System.out.println("this category is not exist");
            return false;
        }
    }
    @ApiOperation(value = "getCategoryById",notes = "查找category")
    public CategoryInfo getCategoryById(long id)
    {
        CategoryInfo categoryInfo = categoryInfoMapper.selectByPrimaryKey(id);

        if (categoryInfo!=null)
        {
            System.out.println("find category!");
            return categoryInfo;
        }
        else
        {
            System.out.println("not find category!");
            return categoryInfo;
        }
    }

    @ApiOperation(value = "updateCategoryName",notes = "更改category的name")
    public Boolean updateCategoryName(String name,long id)
    {
        CategoryInfo categoryInfo = categoryInfoMapper.selectByPrimaryKey(id);
        if (categoryInfo!=null)
        {
            System.out.println("category is exist");
            categoryInfoMapper.updateByPrimaryKey(id,name);
            return true;
        }
        else
        {
            System.out.println("can not find category!");
            return false;
        }
    }

    public CategoryInfo selectCategoryByName(String name)
    {
        CategoryInfo isExist = categoryInfoMapper.selectByName(name);
        if (isExist!=null)
        {
            System.out.println("该目录已经存在");
            return isExist;
        }
        else
        {
            System.out.println("改目录不存在");
            return isExist;
        }
    }
}
