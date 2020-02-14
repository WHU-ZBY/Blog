package com.zby.blog.controller;

import com.zby.blog.pojo.User;
import com.zby.blog.service.LoginService;
import com.zby.blog.service.TokenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private  LoginService loginService;
    @Autowired
    private TokenService tokenService;

    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "登录模块")
    @RequestMapping(value = "/login")
    public Object login(@RequestParam(value = "uid") int uid, @RequestParam(value = "password") String password)
    {
        Boolean result = loginService.isUser(uid,password);
        if (result)
        {
            User user = loginService.getUserByUid(uid);
            System.out.println("login success!");
            String token ="";
            token =  tokenService.sign(user.getNick_name(),uid);
            return token;
        }
        else {
            System.out.println("login failed!");
        }
        return result;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/tokenTest")
    public String test()  {
        return "通过验证";
    }
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "Register Part",notes = "需要判断用户的nickname和两次密码是否输入正确，nickname不能重复，email格式要正确，插入数据库的时候返回uid")
    @RequestMapping(value = "/register")
    public Object register(String nick_name,String password,String re_password,String email)
    {

        String re_email = "www." + email;
        Boolean isGoodNickName = loginService.isNickNameRepeat(nick_name);
        Boolean isEmail = loginService.isEmail(re_email);
        Boolean isPasswordSame = loginService.isPasswordSame(password,re_password);


        if (!isGoodNickName)
        {
            System.out.println("nick_name is not correct!");
            return 1;
        }

        if (!isEmail)
        {
            System.out.println("is not email!");
            return 2;
        }
        if (!isPasswordSame)
        {
            System.out.println("password is not same!");
            return 3;
        }

        User result = loginService.insertUser(nick_name,password,re_email,"1");
        System.out.println("insertUser");
        if (result!=null)
        {
            System.out.println(result.getUid());
            int uid =result.getUid();
            User user = loginService.getUserByUid(uid);
            System.out.println("login success!");
            String token ="";
            token =  tokenService.sign(user.getNick_name(),uid);

            return token;
        }

        return 5;
    }


}
