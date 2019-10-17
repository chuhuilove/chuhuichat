package com.chuhui.chat.interfaces.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * LoginDto
 *
 * @author: cyzi
 * @Date: 2019/10/17 0017
 * @Description:TODO
 */
public class LoginDto implements Serializable {

    private String userName;
    private Integer age;
    private Date date;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
