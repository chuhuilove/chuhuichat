package com.chuhui.chat.web;

import com.alibaba.fastjson.JSON;
import com.chuhui.chat.interfaces.dto.ChatLoginDto;
import org.springframework.http.MediaType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.chuhui.chat.framework.constant.Contants.customTimeFormat2;
import static com.chuhui.chat.framework.constant.Contants.formatCurrentTime;

/**
 * Main
 *
 * @author: cyzi
 * @Date: 2019/10/17 0017
 * @Description:TODO
 */
public class Main {


    public static void main(String[] args) {
        getMediaTypeAll();
    }



    static void getMediaTypeAll(){

        Field[] fields = MediaType.class.getDeclaredFields();
        List<Field> all = Arrays.asList(fields).stream().filter(e -> e.getType().equals(MediaType.class) && !e.getName().startsWith("ALL")).collect(Collectors.toList());

        all.forEach(e-> System.err.println(e.getName()));

    }


    static ChatLoginDto convert(String mesage) {
        ChatLoginDto chatLoginDto = JSON.parseObject(mesage, ChatLoginDto.class);
        return chatLoginDto;
    }

    static String operationStr(String str) {

        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (int i = 0, j = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {
                builder.append(reversal(Arrays.copyOfRange(chars, j, i)));
                builder.append(chars[i]);
                j = i + 1;
            } else if (i == chars.length - 1) {
                builder.append(reversal(Arrays.copyOfRange(chars, j, i + 1)));
            }
        }

        return builder.toString();
    }

    static String reversal(char[] chars) {
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }

}
