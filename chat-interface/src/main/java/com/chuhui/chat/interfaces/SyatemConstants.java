package com.chuhui.chat.interfaces;

import com.chuhui.chat.interfaces.dto.ChatLoginDto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * SyatemConstants
 * <p>
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
    public static final Set<ChatLoginDto> LOGGED_USER = Collections.synchronizedSet(new HashSet<>());

    /**
     * 存储到session中的当前用户标记
     */
    public static final String CURRENT_LOGGED_USER = "currentUser";
    /**
     * 存储到session中的所有用户的标记
     */
    public static final String ALL_LOGGED_USER = "allUsers";


}
