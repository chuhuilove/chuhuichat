package com.chuhui.chat.web.controller;

import com.chuhui.chat.interfaces.dto.HelloMessage;
import com.chuhui.chat.interfaces.resp.Greeting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * GettingController
 *
 * @author: cyzi
 * @Date: 2019/10/18 0018
 * @Description:TODO
 */
@Controller
public class GettingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
