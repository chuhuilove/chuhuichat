package com.chuhui.chat.web.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.chuhui.chat.interfaces.SyatemConstants.CURRENT_LOGGED_USER;

/**
 * ChuHuiChatWebRequestInterceptor
 * <p>
 * //TODO 拦截全局资源....判断如果没有登录,就跳转回登录页面
 * //
 *
 * @author: 纯阳子
 * @date: 2019/10/27
 */
public class ChuHuiChatHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Object attribute = request.getSession().getAttribute(CURRENT_LOGGED_USER);
        if (attribute == null) {
            System.err.println(Thread.currentThread().getName() + " intercept from client request uri:" + request.getRequestURI() + ",because not found session");
            return false;
        }
        return true;
    }

}
