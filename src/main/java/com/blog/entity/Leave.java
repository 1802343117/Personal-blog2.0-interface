package com.blog.entity;


import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

/**
 * @author zhao
 * @ClassName User
 * @Description 留言实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
public class Leave {
    private Long id;
    private boolean tswitch;
    private String username;
    private String content;
    private LocalDateTime publishtime;
    private int likes;
    private String avatar;
    private String additional;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public boolean getTswitch() {
        return tswitch;
    }
    public void setTswitch(boolean tswitch) {
        this.tswitch = tswitch;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public LocalDateTime getPublishtime(){
        return publishtime;
    }
    public void setPublishtime(LocalDateTime publishtime){
        this.publishtime = publishtime;
    }
    public String getpublishtimesc(){
        //创建日期
        Date sj = new Date();
        //创建不同的日期格式
        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");    /*--获得当前时间--*/
        System.out.println(sj);
        return date1.format(sj);
    }

    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }
    public int getLikesjz(){
        return likes + 1;           //增加一个赞
    }

    public String getAvatar(){
        return avatar;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getAdditional(){
        return additional;
    }
    public void setAdditional(String additional){
        this.additional = additional;
    }
}
