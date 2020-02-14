package com.zby.blog.dao;
import com.zby.blog.pojo.Comment;

import java.util.List;

public interface CommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Comment comment);

    Comment selectByPrimaryKey(Long id);

    List<Comment> selectCommentByUid(int uid);
}
