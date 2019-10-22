package com.chuhui.chat.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * AppConfig
 * 只扫描service包下的东西
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@Configuration
@ComponentScan(basePackages = {"com.chuhui.chat.services"})
public class AppConfig {


    @Bean
    public Jedis jedis(){
        Jedis jedis=new Jedis();


        return null;
    }

}
