package com.chuhui.chat.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpRequestHandlerController
 *
 * @author: cyzi
 * @Date: 2019/10/21 0021
 * @Description:TODO
 */
@Component("httpRequest")
public class HttpRequestHandlerController implements HttpRequestHandler {

    public HttpRequestHandlerController(){
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.err.println("this is implements HttpRequestHandler ");

    }
}
