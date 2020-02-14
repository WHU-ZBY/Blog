package com.zby.blog.controller;

import com.zby.blog.pojo.CategoryInfo;
import com.zby.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Boolean createCategory(@RequestParam(value = "name")String name)
    {
        CategoryInfo isExist = categoryService.selectCategoryByName(name);

        if (isExist!=null)
        {
            System.out.println("category is already exist!");
            return false;
        }
        else
        {
            categoryService.insertCategory(name);
            System.out.println("insert category!");
            return true;
        }

    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/selectById")
    public CategoryInfo selectById(@RequestParam(value = "id")long id)
    {
        CategoryInfo categoryInfo=categoryService.getCategoryById(id);
        if (categoryInfo!=null)
        {
            System.out.println("find category!");
            return categoryInfo;
        }
        else {
            System.out.println("can not find category!");
            return categoryInfo;
        }

    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "" +
            "")
    public CategoryInfo selectByName(@RequestParam(value = "name")String name)
    {
        CategoryInfo categoryInfo=categoryService.selectCategoryByName(name);
        if (categoryInfo!=null)
        {
            System.out.println("find category!");
            return categoryInfo;
        }
        else {
            System.out.println("can not find category!");
            return categoryInfo;
        }

    }

}
