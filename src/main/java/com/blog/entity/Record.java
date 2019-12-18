package com.blog.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Record {
    private Long id;
    private String content;
    private String additional;
    private LocalDateTime publishtime;
    private LocalDateTime modigytime;
    private int likes;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getAdditional(){
        return additional;
    }
    public void setAdditional(String additional){
        this.additional = additional;
    }

    public LocalDateTime getPublishtime(){
        return publishtime;
    }
    public void setPublishtime(LocalDateTime publishtime){
        this.publishtime = publishtime;
    }
    public String getPublishtimesc(){
        //创建日期
        Date sj = new Date();
        //创建不同的日期格式
        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");    /*--获得当前时间--*/
        System.out.println(sj);
        return date1.format(sj);
    }

    public LocalDateTime getModigytime(){
        return modigytime;
    }
    public void setModigytime(LocalDateTime modigytime){
        this.modigytime = modigytime;
    }
    public String getModigytimesc(){
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
}
