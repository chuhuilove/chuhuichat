package com.chuhui.chat.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * AppConfig
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@Configuration
@ComponentScan("com.chuhui.chat.services")
public class AppConfig {

    /**
     * 属性资源占位符
     *
     * @return 一个属性资源占位符对象
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 文件上传组件
     *
     * @return CommonsMultipartResolver实例
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

}
