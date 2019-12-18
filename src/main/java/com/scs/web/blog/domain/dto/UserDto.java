package com.scs.web.blog.domain.dto;

import lombok.Data;

/**
 * @author zhao
 * @className UserDto
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
public class UserDto {
    private String account;
    private String password;
    private String nickname;

    public UserDto(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public UserDto(String account, String password, String nickname) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
    }

    public String getMobile() {
        return account;
    }

    public void setMobile(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserDto() {
    }
}