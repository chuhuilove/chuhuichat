package com.chuhui.chat.web.controller;

import com.chuhui.chat.interfaces.IndexInterface;
import com.chuhui.chat.interfaces.dto.ChatLoginDto;
import com.chuhui.chat.web.utils.ServletUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.chuhui.chat.interfaces.SyatemConstants.ALL_LOGGED_USER;
import static com.chuhui.chat.interfaces.SyatemConstants.CURRENT_LOGGED_USER;
import static com.chuhui.chat.interfaces.SyatemConstants.LOGGED_USER;

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
    @Autowired
    private SimpMessagingTemplate template;

    @PostMapping("/login")
    public @ResponseBody
    String login(@RequestBody ChatLoginDto loginDto) {

        // 将当前客户端的信息,存储到数据库中...
        // 要实现单点登录
        // 单点登录,待定
        ServletUtils.getSession().setAttribute(CURRENT_LOGGED_USER, loginDto);


        if (CollectionUtils.isEmpty(LOGGED_USER)) {
            ServletUtils.getSession().setAttribute(ALL_LOGGED_USER, new HashSet<>());
        } else {

            Set<ChatLoginDto> collect = LOGGED_USER.stream().map(ChatLoginDto::getSelf).collect(Collectors.toSet());
            ServletUtils.getSession().setAttribute(ALL_LOGGED_USER, collect);
        }

        if (LOGGED_USER.contains(loginDto)) {
            throw new RuntimeException(loginDto.getUserName() + " has logged");
        }
        LOGGED_USER.add(loginDto);
        /**
         * 这里直接进行重定向
         * 转发和重定向的区别:
         * 转发:浏览器上地址栏不变
         * 重定向:浏览器上地址栏改变
         */

        // 只有经过视图解析器的html文件,才能识别和视图解析器相关的符号...
        //
        return "main";
    }

    /**
     * 返回一个被视图解析器解析过的页面
     *
     * @return
     */

    @GetMapping("/main")
    public String getMainHtml() {
        int a = 1 / 0;
        return "main";
    }


    /**
     * 退出
     */
    @GetMapping("/loginOut")
    public @ResponseBody
    void logOut() {
        HttpSession session = ServletUtils.getSession();
        ChatLoginDto currentUser = (ChatLoginDto) session.getAttribute(CURRENT_LOGGED_USER);
        LOGGED_USER.remove(currentUser);
        System.err.println(currentUser.getUserName() + " has quit");
    }


    @GetMapping("getChat/{fromUser}/{toUser}")
    public String getChat(@PathVariable String fromUser, @PathVariable String toUser) {

        HttpSession session = ServletUtils.getSession();
        session.setAttribute("selfUserName", fromUser);
        session.setAttribute("toUserName", toUser);
        return "chat";
    }







}
