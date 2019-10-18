package com.chuhui.chat.web.config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocketHandler
 *
 * @author: cyzi
 * @Date: 2019/10/18 0018
 * @Description:TODO
 */
public class WebSocketHandler extends TextWebSocketHandler {


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {


    }


}
