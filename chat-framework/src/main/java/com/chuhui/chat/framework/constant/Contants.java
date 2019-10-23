package com.chuhui.chat.framework.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Contants
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
public class Contants {

    public static final  DateTimeFormatter customTimeFormat=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm");
    public static final  DateTimeFormatter customTimeFormat2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm:SSS");



    /**
     * 格式化当前时间
     * @param format 格式
     * @return 格式化后的当前时间
     */
    public static String formatCurrentTime(DateTimeFormatter format){
       return  LocalDateTime.now().format(format);

    }



}
