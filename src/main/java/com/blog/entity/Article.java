package com.blog.entity;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhao
 * @ClassName User
 * @Description 文章实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
public class Article {
    private Long id;
    private String title;
    private String content;
    private String cover;
    private int comments;
    private int likes;
    private LocalDate publishTime;
    private LocalDate update;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getCover(){
        return cover;
    }
    public void setCover(String cover){
        this.cover = cover;
    }

    public int getComments(){
        return comments;
    }
    public void setComments(int comments){
        this.comments = comments;
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

    public LocalDate getUpdate(){
        return update;
    }
    public void setUpdate(LocalDate update){
        this.update = update;
    }
}
