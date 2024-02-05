package com.driver.models;

import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="image")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;
    private String description;
    private String dimension;

    @ManyToOne
    @JoinColumn
    private Blog blog;


}