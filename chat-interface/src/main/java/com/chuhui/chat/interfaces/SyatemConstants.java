package com.chuhui.chat.interfaces;

import com.chuhui.chat.interfaces.dto.ChatLoginDto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * SyatemConstants
 *
 * 系统变量
 *
 * @author: cyzi
 * @Date: 2019/10/23 0023
 * @Description:TODO
 */
public class SyatemConstants {


    /**
     * 已经登录的用户
     */
    public static final Set<ChatLoginDto> LOGGED_USER=Collections.synchronizedSet(new HashSet<>());


}
