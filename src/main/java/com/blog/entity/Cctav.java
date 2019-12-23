package com.blog.entity;

public class Cctav {
    private long id;
    private String name;
    private String addres;
    private String cover;
    private String content;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
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

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
