package com.chuhui.chat.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Dispath
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@Configuration
@ComponentScan("com.chuhui.chat.web.controller")
@EnableWebMvc
public class  DispatcherConfig extends WebMvcConfigurationSupport {


    /**
     * 配置视图解析器
     * @return 返回一个视图解析器实例
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver templateResolver = new InternalResourceViewResolver();
        templateResolver.setPrefix("/WEB-INF");
        templateResolver.setSuffix(".html");
        templateResolver.setContentType("text/html;charset=utf-8");
        return templateResolver;
    }



}
