package com.chuhui.chat.interfaces.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

/**
 * ChatLoginDto
 *
 * @author: cyzi
 * @Date: 2019/10/23 0023
 * @Description:TODO
 */
@Getter
@Setter
@ToString

public class ChatLoginDto {

    private String userName;
    private String passWord;
    private Date birDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getBirDate() {
        return birDate;
    }

    public void setBirDate(Date birDate) {
        this.birDate = birDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChatLoginDto that = (ChatLoginDto) o;
        return userName.equals(that.userName) &&
                passWord.equals(that.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, passWord);
    }


    public ChatLoginDto getSelf() {
        ChatLoginDto chatLoginDto = new ChatLoginDto();

        chatLoginDto.setBirDate(birDate);
        chatLoginDto.setUserName(userName);
        chatLoginDto.setPassWord(passWord);
        return chatLoginDto;
    }

}
