package com.chuhui.chat.web.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ServletUtils
 *
 * @author: cyzi
 * @Date: 2019/10/25 0025
 * @Description:TODO
 */
public final class ServletUtils {


    /**
     * 同一个浏览器中的的session的hashcode是相同的
     * @return 一个session对象
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

    private static ServletRequestAttributes getServletRequestAttributes() {
        ServletRequestAttributes servletRequestAttributes = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        }
        return servletRequestAttributes;
    }


}
