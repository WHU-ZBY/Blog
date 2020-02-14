package com.zby.blog.service;

import com.zby.blog.dao.*;
import com.zby.blog.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ArticleService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private ArticlePictureMapper articlePictureMapper;
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Autowired
    private ArticleCommentMapper articleCommentMapper;
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;
    @Autowired
    private  ArticleIntroMapper articleIntroMapper;
    @Autowired
    private UserArticleCountMapper userArticleCountMapper;


    Date day=new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//需要判断插入操作是否成功的插入了数据
//    ArticleInfo
    public boolean insertArticleInfo(Article article){
        ArticleInfo articleInfo =new ArticleInfo();
        articleInfo.setArticle_id(article.getArticle_id());
        articleInfo.setId(article.getId());
        articleInfo.setTitle(article.getTitle());
        articleInfo.setUid(article.getUid());


        articleInfoMapper.insert(articleInfo);
        return true;
    }

    public ArticleInfo selectArticleInfo(Long id)
    {
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(id);
        return  articleInfo;
    }

    public int deleteArticleInfo(Long id)
    {
        int resulte = articleInfoMapper.deleteByPrimaryKey(id);
        return resulte;
    }



//    ArticleCategory
    public boolean insertArticleCategory(Article article)
    {
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticle_id(article.getArticle_id());
        articleCategory.setCategory_id(article.getCategory_id());
        articleCategory.setId(article.getId());

        articleCategoryMapper.insert(articleCategory);
        return true;
    }


    public ArticleCategory selectArticleCategory(Long id)
    {
        ArticleCategory articleCategory = articleCategoryMapper.selectByPrimaryKey(id);
        return  articleCategory;
    }

    public int deleteArticleCategory(Long id)
    {
        int result = articleCategoryMapper.deleteByPrimaryKey(id);
        return result;
    }



//      ArticleContent
    public boolean insertArticleContent(Article article)
    {
        ArticleContent articleContent = new ArticleContent();

        articleContent.setArticle_id(article.getArticle_id());
        articleContent.setContent(article.getContent());
        articleContent.setId(article.getId());

        articleContentMapper.insert(articleContent);
        return true;

    }


    public ArticleContent selectArticleContent(Long id)
    {
        ArticleContent articleContent = articleContentMapper.selectByPrimaryKey(id);
        return articleContent;
    }

    public int deleteArticleContent(Long id)
    {
        int result = articleContentMapper.deleteByPrimaryKey(id);
        return result;
    }


//    ArticlePicture
    public boolean insertArticlePicture(Article article)
    {
        ArticlePicture articlePicture = new ArticlePicture();

        articlePicture.setId(article.getId());
        articlePicture.setArticle_id(article.getArticle_id());
        articlePicture.setPicture_url(article.getPicture_url());

        articlePictureMapper.insert(articlePicture);
        return true;
    }

    public ArticlePicture selectArticlePicture(Long id)
    {
        ArticlePicture articlePicture = articlePictureMapper.selectByPrimaryKey(id);
        return articlePicture;
    }

    public int deleteArticlePicture(Long id)
    {
        int result = articlePictureMapper.deleteByPrimaryKey(id);
        return result;
    }

    public List<ArticleInfo> selectArticleByUid(int uid)
    {
        return articleInfoMapper.selectArticleByUid(uid);
    }

//  ArticleIntro
    public boolean insertArticleIntro(Article article)
    {
        ArticleIntro articleIntro = new ArticleIntro();
        articleIntro.setId(article.getId());
        articleIntro.setArticle_id(article.getArticle_id());
        articleIntro.setIntro(article.getIntro());
        articleIntro.setUid(article.getUid());

        articleIntroMapper.insert(articleIntro);
        return true;
    }

    public int deleteArticleIntro(Long id)
    {
        int result = articleIntroMapper.deleteByPrimaryKey(id);
        return result;
    }

    public ArticleIntro selectArticleIntro(Long id)
    {
        ArticleIntro articleIntro = articleIntroMapper.selectByPrimaryKey(id);
        return articleIntro;
    }
    public List<ArticleIntro> getArticleIntroByUid(int uid)
    {
        return articleIntroMapper.getArticleIntroByUid(uid);
    }
//    自动生成Article_id！
    public int calculateArticleIdByUid(int uid)
    {
        int userArticle_count =userArticleCountMapper.selectUserArticleCountByUid(uid);
        StringBuilder sb = new StringBuilder();
        sb.append(uid);
        sb.append(userArticle_count);
        System.out.println("userArticle_count: "+userArticle_count);
        System.out.println("sb: "+sb);
        int result = -1;
        try {
            result = Integer.parseInt(sb.toString());// 将得到的字符串转为int类型
            System.out.println("result: "+result);
            return result;
        } catch (NumberFormatException e) {
        }
        // 返回-1表示操作失败
        return result;
    }

    public int addArticleCount(int uid)
    {
        int userArticle_count= userArticleCountMapper.selectUserArticleCountByUid(uid);
        System.out.println("date: " + userArticle_count);
        int count = 1 + userArticle_count;
        System.out.println("addCount: "+count);
        userArticleCountMapper.addUserArticleCount(uid,count);
        return count;
    }
    public int deleteArticleCount(int uid)
    {
        int userArticle_count = userArticleCountMapper.selectUserArticleCountByUid(uid);
        int count = userArticle_count-1;
        userArticleCountMapper.deleteUserArticleCount(uid,count);
        if (count<0)
        {
            count= 0 ;
        }
        return count;
    }





}
