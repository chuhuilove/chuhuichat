package com.chuhui.chat.web.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ImplementController
 *
 * @author: cyzi
 * @Date: 2019/10/21 0021
 * @Description:TODO
 */
@Component
public class ImplementController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.err.println("this is implements Controller  ");


        return null;
    }
}
