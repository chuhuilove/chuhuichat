package com.chuhui.chat.web.config;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ChuHuiChatHandlerMapping
 *
 * @author: cyzi
 * @Date: 2019/10/21 0021
 * @Description:TODO
 */
public class ChuHuiChatHandlerMapping implements HandlerMapping {



    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {

        // 可以自己定义一个HandlerMapping..
        // 可是直接返回一个.html文件..怎么办呢??

        return null;
    }
}
