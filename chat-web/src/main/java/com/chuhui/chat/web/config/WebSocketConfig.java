package com.chuhui.chat.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocketConfig
 * <p>
 * 可不可以选择继承{@link WebSocketMessageBrokerConfigurationSupport} 这个类呢?
 * <p>
 *
 * @author: cyzi
 * @Date: 2019/10/18 0018
 * @Description:TODO
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    SimpMessagingTemplate template;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        /***
         * 这个订阅加上@SendTo注解里面的字符串,组成了客户端的订阅
         */
        config.enableSimpleBroker("/topic","/user");

        /***
         * 订阅以/app开头的消息体
         *
         * 假如发送的消息为/app/hello
         *
         * 则会以路由的方式寻找加了@MessageMapping("/hello")注解的方法...然后执行
         *
         *
         */
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chws/").withSockJS();
    }



}
