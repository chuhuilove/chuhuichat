package com.chuhui.chat.web.controller;

import com.chuhui.chat.interfaces.IndexInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@RestController
public class IndexController {

    private IndexInterface indexService;

    @Autowired
    public IndexController(IndexInterface indexService) {
        this.indexService = indexService;
        System.err.println(this.indexService);
    }

    @RequestMapping("getString")
    public String getString() {
        System.err.println("lalaal");
        System.err.println("lalaal");
        System.err.println("lalaal");
        System.err.println("lalaal");
        return indexService.getString();
    }


}
