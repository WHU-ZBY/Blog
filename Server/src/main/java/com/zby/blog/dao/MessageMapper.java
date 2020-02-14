package com.zby.blog.dao;

import com.zby.blog.pojo.Message;

import java.util.List;

public interface MessageMapper {


    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    Message selectByPrimaryKey(Long id);

    List<Message> selectMessageByUid(int uid);
}