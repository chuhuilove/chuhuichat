package com.chuhui.chat.web.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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


        String requestUri = request.getRequestURI();


        // 异常解析器中
        // 还需要明白ThymeleafViewResolver 怎么使用  怎么配合ModelAndView使用


        if (ex instanceof NoHandlerFoundException) {

            // 拦截/chuhuichat/这个uri
            // 手动重定向到index.html页面,不走视图解析器
            if(requestUri.equalsIgnoreCase(request.getContextPath()+"/")){
                ModelAndView view = new ModelAndView("redirect:/index.html");
                view.setStatus(HttpStatus.OK);
                return view;
            }

            // 如果真的啥也没有...
            // 重定向到404页面
            ModelAndView view = new ModelAndView("404");
            view.setStatus(HttpStatus.NOT_FOUND);
            view.addObject("NotFound", requestUri);
            return view;
        }

        // 如果内部错误....
        // 重定向到error页面
        ModelAndView view = new ModelAndView("error");
        view.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        view.addObject("errorMessage", ex.getMessage() + "---->" + requestUri);

        return view;
    }
}
