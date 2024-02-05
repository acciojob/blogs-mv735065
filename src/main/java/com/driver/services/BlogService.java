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

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        User user=userRepository1.findById(userId).get();

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
