package com.blog.entity;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * @author zhao
 * @ClassName User
 * @Description 用户实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
public class User {
    private Long id;
    private String account;
    private String password;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String introduction;
    private Short follows;
    private LocalDateTime createTime;
    private Short status;
    private String mobile;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getAccount(){
        return account;
    }
    public void setAccount(String account){
        this.account = account;
    }
    //自主生成账号
    public String getAccountsc() {
        int c = new Random().nextInt(99999);
        int n = new Random().nextInt(99999);
        String accountsc = Integer.toString(c);
        String accountsn = Integer.toString(n);
        return  accountsc + accountsn;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getAvatar(){
        return avatar;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatarmr() {
        return "http://1t.click/byut";
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public LocalDate getBirthday(){
        return birthday;
    }
    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }
    public String getBirthdaysc() {
        //创建日期
        Date sj = new Date();
        //创建不同的日期格式
        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");    /*--获得当前时间--*/
        System.out.println(sj);
        return date1.format(sj);
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getIntroduction(){
        return introduction;
    }
    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }

    public Short getFollows(){
        return follows;
    }
    public void setFollows(Short follows){
        this.follows = follows;
    }

    public LocalDateTime getCreateTime(){
        return createTime;
    }
    public void setCreateTime(LocalDateTime createTime){
        this.createTime = createTime;
    }
    public String getCreateTimesc() {
        //创建日期
        Date sj = new Date();
        //创建不同的日期格式
        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");    /*--获得当前时间--*/
        System.out.println(sj);
        return date1.format(sj);
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status = status;
    }

    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
}
