package com.chuhui.chat.web.config;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * ChuHuiChatWebRequestInterceptor
 * <p>
 * //TODO 拦截全局资源....判断如果没有登录,就跳转回登录页面
 * //
 *
 * @author: 纯阳子
 * @date: 2019/10/27
 */
public class ChuHuiChatHandlerInterceptor implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest request) throws Exception {

        System.err.println(request.getRemoteUser());

    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }

//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//
//        HttpSession session = request.getSession();
//
//        Object currentUser = session.getAttribute("currentUser");
//        if (currentUser == null || !LOGGED_USER.contains(currentUser)) {
//            // 重定向到index
//            System.err.println("重定向到登录界面");
//            return false;
//        }
//        return true;
//    }


}
