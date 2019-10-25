package com.chuhui.chat.web;

import com.alibaba.fastjson.JSON;
import com.chuhui.chat.interfaces.dto.ChatLoginDto;
import org.springframework.http.MediaType;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.chuhui.chat.framework.constant.Contants.*;
import static com.ztesoft.zsmart.jdbc.qdb.util.DateUtil.string2SQLDate;
import static java.util.Calendar.SECOND;

/**
 * Main
 *
 * @author: cyzi
 * @Date: 2019/10/17 0017
 * @Description:TODO
 */
public class Main {


    public static void main(String[] args) throws ParseException {
        getTimeZone();
    }


    static void getMediaTypeAll() {

        Field[] fields = MediaType.class.getDeclaredFields();
        List<Field> all = Arrays.asList(fields).stream().filter(e -> e.getType().equals(MediaType.class) && !e.getName().startsWith("ALL")).collect(Collectors.toList());

        all.forEach(e -> System.err.println(e.getName()));

    }

    static void getTimeZone() throws ParseException {

//        TimeZone defaultTimeZone = TimeZone.getDefault();
//
//
//        System.err.println(defaultTimeZone.getDisplayName());
//        System.err.println(defaultTimeZone.getID());


//        String[] availableIDs = TimeZone.getAvailableIDs();
//        Arrays.stream(availableIDs).forEach(System.err::println);

//        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(16, "Pacific/Fiji");
//
//        TimeZone.setDefault(simpleTimeZone);

//        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//        TimeZone timeZone = format.getTimeZone();
//        System.err.println(timeZone.getRawOffset());
//        System.err.println(timeZone.getID());
//        System.err.println(timeZone.getDisplayName());

//        String timeStr="20191110021706";
//
//        Date parse = format.parse(timeStr);
//
//        System.err.println(format.format(parse));


        System.err.println(string2SQLDate("20191103011023", "yyyyMMddHHmmss"));

        final TimeZone defaultTimeZone = TimeZone.getDefault();

        System.err.println(defaultTimeZone.getDisplayName());
        System.err.println(defaultTimeZone.getID());


        Calendar instance = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

        Date parse = format.parse("20190101000000");
        instance.setTime(parse);

        Date otherTime = format.parse("20200101000000");
        System.err.println("start time" + formatCurrentTime(customTimeFormat));

        LinkedList<Date> collect = (LinkedList<Date>) getAllTimeOfOneYear(instance, otherTime);

        System.err.println("start DST:"+format.format(collect.getFirst()));
        System.err.println("end DST:"+format.format(collect.getLast()));


        System.err.println("end time" + formatCurrentTime(customTimeFormat));

        System.err.println("this is debug");
        System.err.println("this is debug");
        System.err.println("this is debug");
        System.err.println("this is debug");


        if (defaultTimeZone.useDaylightTime()) {

            System.err.println("used daylight time");

        }
    }


    static List<Date> getAllTimeOfOneYear(Calendar calendar, Date finalTime) {
        List<Date> dates = new LinkedList<>();

        final TimeZone defaultTimeZone = TimeZone.getDefault();

        Date time = calendar.getTime();
        while (time.compareTo(finalTime) < 0) {
//            if (defaultTimeZone.inDaylightTime(time)) {
                dates.add(time);
//            }
            calendar.add(SECOND, 1);
            time = calendar.getTime();
        }

//        Caused by: java.lang.IllegalArgumentException: the date string 20191110021706 is not matching format: yyyyMMddHHmmss

        System.err.println("all time:"+dates.size());
        return dates;
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
//https://www.iteye.com/blog/sesame-2112571

}
