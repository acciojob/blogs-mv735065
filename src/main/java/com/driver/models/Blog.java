package com.driver.models;

//import lombok.*;
import lombok.Builder;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="blog")
@AllArgsConstructor
@Builder

//@NoArgsConstructor


public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;


    private String title;

    private String content;

    private Date pubDate;



    @ManyToOne
    @JoinColumn
    private User user;


    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList=new ArrayList<>();

    public Blog() {
    }

    public Blog(Integer id, String title, String content, Date pubDate, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public User getUser() {
        return user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}