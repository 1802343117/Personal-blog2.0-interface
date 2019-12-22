package com.blog.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Colm {
    private Long id;
    private Long userid;
    private Long articleid;
    private String content;
    private String username;
    private String avatar;
    private LocalDate publishTime;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Long getUserid(){
        return userid;
    }
    public void setUserid(Long userid){
        this.userid = userid;
    }

    public Long getArticleid(){
        return articleid;
    }
    public void setArticleid(Long articleid){
        this.articleid = articleid;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getPublishTime(){
        return publishTime;
    }
    public void setPublishTime(LocalDate publishTime){
        this.publishTime = publishTime;
    }
    public String getPublishTimesc(){
        //创建日期
        Date sj = new Date();
        //创建不同的日期格式
        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");    /*--获得当前时间--*/
        System.out.println(sj);
        return date1.format(sj);
    }
}
