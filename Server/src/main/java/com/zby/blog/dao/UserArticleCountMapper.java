package com.zby.blog.dao;

public interface UserArticleCountMapper {
     int insertUserArticleCount(int uid,int article_count);
     int addUserArticleCount(int uid,int article_count);
     int selectUserArticleCountByUid(int uid);
     int deleteUserArticleCount(int uid,int article_count);

}
