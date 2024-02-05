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
    private Integer imageId;

//    @Getter
    private String description;

    private String dimension;


    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image() {
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public String getDimension() {
        return dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}