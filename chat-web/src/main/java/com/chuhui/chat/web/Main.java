package com.chuhui.chat.web;

import java.util.Arrays;
import java.util.UUID;

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

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 2000; i++) {

            builder.append(UUID.randomUUID().toString().replaceAll("-", ""));
            builder.append(" ");
        }


        String str = builder.toString().trim();

        System.err.println("start:" + formatCurrentTime(customTimeFormat2));

        System.err.println(operationStr(str));
        System.err.println("end:" + formatCurrentTime(customTimeFormat2));

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
