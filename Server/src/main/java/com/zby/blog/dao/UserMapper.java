package com.zby.blog.dao;
import com.zby.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUserByPrimaryKey(int uid);

    User isNickNameRepeat(String nick_name);

    Boolean insertUser(User user);
}