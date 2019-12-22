package com.blog.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhao
 * @ClassName User
 * @Description 音乐实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
public class Music {
    private Long id;
    private String musictitle;
    private String category;
    private String addres;
    private String author;
    private String cover;
    private int likes;
    private LocalDate publish;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getMusictitle(){
        return musictitle;
    }
    public void setMusictitle(String musictitle){
        this.musictitle = musictitle;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(){
        this.category = category;
    }

    public String getAddres(){
        return addres;
    }
    public void setAddres(String addres){
        this.addres = addres;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
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
}
