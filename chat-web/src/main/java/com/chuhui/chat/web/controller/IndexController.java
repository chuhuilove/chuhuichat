package com.chuhui.chat.web.controller;

import com.chuhui.chat.interfaces.IndexInterface;
import com.chuhui.chat.interfaces.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * IndexController
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@Controller
public class IndexController {

    @Autowired
    private IndexInterface indexService;


    @RequestMapping("/getSuccess")
    public String getSuccess() {



        System.err.println("我要獲取調用鏈");
        System.err.println("我要獲取調用鏈");
        System.err.println("我要獲取調用鏈");
        return "success";
    }

    /**
     * 首页
     *
     * @return 首页
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String index1() {
        return index();
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/single")
    public String single() {
        return "single";
    }

    @RequestMapping("/websocket")
    public String websocket() {
        return "websocket";
    }

    /**
     * 首页
     *
     * @return 首页
     */
    @RequestMapping("/index2")
    public @ResponseBody
    LoginDto index2() {

        LoginDto dto = new LoginDto();
        dto.setUserName(indexService.getString());
        dto.setAge(100);
        dto.setDate(new Date());

        return dto;
    }


}
