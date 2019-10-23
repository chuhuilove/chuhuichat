package com.chuhui.chat.web.controller;

import com.chuhui.chat.interfaces.IndexInterface;
import com.chuhui.chat.interfaces.dto.ChatLoginDto;
import com.chuhui.chat.interfaces.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

import static com.chuhui.chat.interfaces.SyatemConstants.LOGGED_USER;

/**
 * IndexController
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@Controller
@RequestMapping("/index")
public class IndexController {


    @Autowired
    private IndexInterface indexService;

    @PostMapping("/login")
    public @ResponseBody
    LoginDto index2(@RequestBody ChatLoginDto loginDto, HttpServletRequest request) {

        System.err.println("1111111");
        System.err.println("1111111");
        System.err.println("1111111");

        LOGGED_USER.add(loginDto);


        // 登录以后,需要保存登陆者信息
        // 获取session ...
        // 怎么做呢?
        // 使用HttpS

//        HttpSession session = request.getSession();


        LoginDto dto = new LoginDto();
        dto.setUserName(indexService.getString());
        dto.setAge(100);
        dto.setDate(new Date());

        return dto;
    }


//
//    @RequestMapping("/getSuccess")
//    public String getSuccess() {
//
//
//
//        System.err.println("我要獲取調用鏈");
//        System.err.println("我要獲取調用鏈");
//        System.err.println("我要獲取調用鏈");
//        return "success";
//    }
//
//    /**
//     * 首页
//     *
//     * @return 首页
//     */
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("/")
//    public String index1() {
//        return index();
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping("/about")
//    public String about() {
//        return "about";
//    }
//
//    @RequestMapping("/single")
//    public String single() {
//        return "single";
//    }
//
//    @RequestMapping("/websocket")
//    public String websocket() {
//        return "websocket";
//    }
//
//    /**
//     * 首页
//     *
//     * @return 首页
//     */
//    @RequestMapping("/index2")
//    public @ResponseBody
//    LoginDto index2() {
//
//        LoginDto dto = new LoginDto();
//        dto.setUserName(indexService.getString());
//        dto.setAge(100);
//        dto.setDate(new Date());
//
//        return dto;
//    }


}
