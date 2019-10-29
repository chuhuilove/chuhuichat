package com.chuhui.chat.web.config;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ChatHandlerExceptionResolver
 * 自定义的异常解析器
 *
 * @author: cyzi
 * @Date: 2019/10/17 0017
 * @Description:TODO
 */
public class ChatHandlerExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.err.println(ex.getMessage());
        System.err.println(ex.getMessage());
        System.err.println(ex.getMessage());
        System.err.println(ex.getMessage());

        // 异常解析器中
        // 还需要明白ThymeleafViewResolver 怎么使用  怎么配合ModelAndView使用


        return null;
    }
}
