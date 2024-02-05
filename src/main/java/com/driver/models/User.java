package com.driver.models;

//import lombok.*;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.Builder;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="user")
@Builder
// @NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter


public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;

    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> blogList=new ArrayList<>();

}