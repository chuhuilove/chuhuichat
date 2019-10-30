package com.chuhui.chat.web.config;

import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    private static final String NOT_INTERCEPTOR_REQUEST = "/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String requestUri = request.getRequestURI();

        Object attribute = request.getSession().getAttribute(CURRENT_LOGGED_USER);

        if (attribute == null &&
                requestUri.endsWith(NOT_INTERCEPTOR_REQUEST) &&
                request.getMethod().equalsIgnoreCase(HttpMethod.POST.name())) {
            return true;
        }

        if (attribute == null) {
            try {
                response.sendRedirect(request.getContextPath() + "/index.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

}
