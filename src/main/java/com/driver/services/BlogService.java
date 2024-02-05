package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog  createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        Optional<User> user1=userRepository1.findById(userId);

        if(user1.isEmpty()) return null;

        //User user=userRepository1.findById(userId).get();
       User user =user1.get();

        Blog blog=Blog.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();

        user.getBlogList().add(blog);

        blog=blogRepository1.save(blog);
        return blog;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images

        Optional<User> user1=blogRepository1.findById(blogId);

        if(user1.isEmpty()) return ;


        Blog blog=blogRepository1.findById(blogId).get();

        List<Image> list=blog.getImageList();
        list.clear();


        blogRepository1.deleteById(blogId);

//        List<Image> list=blog.getImageList();
//
//        for(Image image : list){
//
//            Integer imageId=
//
//        }



    }
}
