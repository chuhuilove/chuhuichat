package com.chuhui.chat.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeType;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

/**
 * WebSocketConfig
 *
 * 可不可以选择继承{@link WebSocketMessageBrokerConfigurationSupport} 这个类呢?
 *
 * @author: cyzi
 * @Date: 2019/10/18 0018
 * @Description:TODO
 */
@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig extends WebSocketMessageBrokerConfigurationSupport {



    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chuhuichat/chws/").withSockJS()
                .setStreamBytesLimit(512 * 1024)
                .setHttpMessageCacheSize(1000)
                .setDisconnectDelay(30 * 1000);
    }

//    @Override
//    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
//
//        System.err.println("this is debugger ");
//        System.err.println("this is debugger ");
//        System.err.println("this is debugger ");
//        System.err.println("this is debugger ");
//
//
//        return true;
//    }

//    public class CustomMessageConverter extends AbstractMessageConverter {
//
//        protected CustomMessageConverter(MimeType supportedMimeType) {
//            super(supportedMimeType);
//        }
//
//        @Override
//        protected boolean supports(Class<?> clazz) {
//            return false;
//        }
//    }

}
