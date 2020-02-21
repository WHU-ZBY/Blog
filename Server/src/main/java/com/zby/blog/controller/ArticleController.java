package com.zby.blog.controller;

import com.zby.blog.pojo.Article;
import com.zby.blog.pojo.ArticleContent;
import com.zby.blog.pojo.ArticleInfo;
import com.zby.blog.pojo.ArticleIntro;
import com.zby.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/create")
    public int createArticle( @RequestBody Article article)
    {
//        根据用户的信息生成ArticleId
            int article_id = articleService.calculateArticleIdByUid(article.getUid());
            article.setArticle_id(article_id);
            System.out.println("article_id: "+article_id);
//        调用service中的方法
            articleService.insertArticleInfo(article);
            articleService.insertArticleCategory(article);
            articleService.insertArticleContent(article);
            articleService.insertArticlePicture(article);
            articleService.insertArticleIntro(article);
            articleService.addArticleCount(article.getUid());
            return 1;

//        是否成功创建新的文章
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Boolean deleteArticle( Long id)
    {
//        调用service中的方法
        articleService.deleteArticleCategory(id);
        articleService.deleteArticleContent(id);
        articleService.deleteArticleInfo(id);
        articleService.deleteArticlePicture(id);
        articleService.deleteArticleIntro(id);
//        是否成功创建新的文章

        Boolean result = true;
        return result;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getAllArticleByUid")
    public List<ArticleInfo> getAllArticleByUid(int uid)
    {
        List<ArticleInfo> list = articleService.selectArticleByUid(uid);
        if (list.size()==0)
        {
            System.out.println("没有发现任何文章");
            return list;
        }
        else {
            return list;
        }

    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getArticleIntroByUid")
    public List<ArticleIntro> getArticleIntroByUid(int uid)
    {
        return articleService.getArticleIntroByUid(uid);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getArticleByArticleId")
    public Article getArticleByArticleId(int articleId)
    {
        ArticleIntro articleIntro = articleService.getArticleIntroByArticleId(articleId);
        ArticleContent articleContent = articleService.selectArticleContent(articleId);
        Article article = new Article();
        article.setArticle_id(articleId);
        article.setIntro(articleIntro.getIntro());
        article.setContent(articleContent.getContent());
        article.setTitle(articleIntro.getTitle());
        article.setUid(articleIntro.getUid());
        article.setCreateDate(articleIntro.getCreateDate());
        return article;

    }
}
