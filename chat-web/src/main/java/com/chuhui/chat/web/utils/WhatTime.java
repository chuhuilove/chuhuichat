package com.chuhui.chat.web.utils;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.SECOND;

/**
 * WhatTime
 *
 * @author: cyzi
 * @Date: 2019/10/25 0025
 * @Description:TODO
 */
public class WhatTime {


    public static void main(String argv[]) throws Exception {
//        https://www.jb51.net/article/129143.htm 夏时令 示例
        Calendar instance = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

        Date parse = format.parse("20190101000000");
        instance.setTime(parse);
        Date otherTime = format.parse("20200101000000");


//        timeZone = TimeZone.getTimeZone("GMT");
//        WhatTime.testDayTime(timeZone);
//
//        System.out.println("----------------------------------------------------------------");
//
//        timeZone = TimeZone.getTimeZone("America/Los_Angeles");
//        WhatTime.testDayTime(timeZone);


    }




}
