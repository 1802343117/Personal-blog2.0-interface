package com.blog.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhao
 * @ClassName User
 * @Description 工具实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
public class Tool {
    private Long id;
    private String toolname;
    private String addres;
    private String cover;
    private int likes;
    private LocalDate publish;
    private String adout;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getToolname(){
        return toolname;
    }
    public void setToolname(String toolname){
        this.toolname = toolname;
    }

    public String getAddres(){
        return addres;
    }
    public void setAddres(String addres){
        this.addres = addres;
    }

    public String getCover(){
        return cover;
    }
    public void setCover(String cover){
        this.cover = cover;
    }

    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }

    public LocalDate getPublish(){
        return publish;
    }
    public void setPublish(LocalDate publish){
        this.publish = publish;
    }

    public String getAdout(){
        return adout;
    }
    public void setAdout(String adout){
        this.adout = adout;
    }
}
