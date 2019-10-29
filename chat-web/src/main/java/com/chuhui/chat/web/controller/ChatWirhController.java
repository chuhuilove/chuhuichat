package com.chuhui.chat.web.controller;

import com.chuhui.chat.interfaces.dto.HelloMessage;
import com.chuhui.chat.interfaces.resp.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import static com.chuhui.chat.interfaces.SyatemConstants.LOGGED_USER;

/**
 * GettingController
 *
 * @author: cyzi
 * @Date: 2019/10/18 0018
 * @Description:TODO
 */
@Controller
@RequestMapping("/chatWith")
public class ChatWirhController {


    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {

        System.err.println("this is websocket message");
        System.err.println("this is websocket message");

        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


    @PostMapping("/chat")
    public @ResponseBody
    void chat(String message, String username) {

        System.err.println("has message:" + message + " userName:" + username);

        template.convertAndSendToUser(username, "/app", message);

    }

    /**
     * server 更新在线人数列表的方法
     * 他会给所有订阅了/topic/userList的ws客户端发送消息
     *
     * @return
     */
    @RequestMapping("/userList")
    @ResponseBody
    public void userList() {
        final StringBuilder sBuilder = new StringBuilder();
        LOGGED_USER.forEach(e -> {
            sBuilder.append(e.getUserName());
            sBuilder.append(",");
        });
        template.convertAndSend("/topic/userList", sBuilder.substring(0, sBuilder.length() - 1));
    }
}
