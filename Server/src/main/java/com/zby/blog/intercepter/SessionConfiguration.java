package com.zby.blog.intercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
@EnableTransactionManagement
public class SessionConfiguration extends WebMvcConfigurerAdapter  {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        配置登录拦截器
//        registry.addInterceptor(loginInterceptor())
//                .excludePathPatterns("/login")//不需要拦截的url
//                .excludePathPatterns("/loginOut")//不需要拦截的url
//                .excludePathPatterns("/swagger-ui.html")
//                .excludePathPatterns("/test/*")
//                .excludePathPatterns("/register")
//                .addPathPatterns("/**");
//        //配置其他拦截器(会按配置顺序拦截，先配置的先拦截)
//        // ...
//
//
//        //加入拦截
//        super.addInterceptors(registry);
    }


}
