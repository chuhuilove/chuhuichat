package com.chuhui.chat.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig
 * 只扫描service包下的东西
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@Configuration
@ComponentScan(basePackages = {"com.chuhui.chat.services"})
public class AppConfig {

// redis 集成暂时先不做...集成有些问题
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("118.24.141.172", 6370);
//        return new JedisConnectionFactory(config);
//    }
//
//    @Bean
//    public RedisTemplate redisTemplate(JedisConnectionFactory factory) {
//        RedisTemplate template = new RedisTemplate();
//        template.setConnectionFactory(factory);
//        return template;
//    }

}
