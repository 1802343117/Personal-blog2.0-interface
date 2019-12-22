package com.blog.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * @author zhao
 * @ClassName User
 * @Description 图片实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
public class Gallery {
    private Long id;
    private Long userID;
    private String figuretitle;
    private String figureinfo;
    private String address;
    private int likes;
    private LocalDate publishTime;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Long getUserID(){
        return userID;
    }
    public void setUserID(Long userID){
        this.userID = userID;
    }

    public String getFiguretitle(){
        return figuretitle;
    }
    public void setFiguretitle(String figuretitle){
        this.figuretitle = figuretitle;
    }

    public String getFigureinfo(){
        return figureinfo;
    }
    public void setFigureinfo(String figureinfo){
        this.figureinfo = figureinfo;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }

    public LocalDate getPublishTime(){
        return publishTime;
    }
    public void setPublishTime(LocalDate publishTime){
        this.publishTime = publishTime;
    }
}
