package com.driver.models;

import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="image")
@Builder
//@NoArgsConstructor
@AllArgsConstructor


public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Getter
    private String description;

    private String dimensions;


    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer imageId) {
        this.id = imageId;
    }

    public String getDescription() {
        return description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimensions(String dimension) {
        this.dimensions = dimension;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}