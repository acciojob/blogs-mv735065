package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();

        Image image=Image.builder()
                .description(description)
                .dimensions(dimensions)
                .blog(blog)
                .build();

        blog.getImageList().add(image);
        image=imageRepository2.save(image);
        return image;

    }

    public void deleteImage(Integer id){

        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        Integer areaOfScreen=area(screenDimensions);

        Image image=imageRepository2.findById(id).get();

        Integer areaOfImage=area(image.getDimensions());

      //  String length[]=screenDimensions.split("")

       int count=(areaOfScreen/areaOfImage);

        return count;

    }


    public Integer area(String screenDimensions){
        Integer length=0;
        Integer breadth;

        Integer sum=0;

        for(int i=0;i<screenDimensions.length();i++){
            char ch=screenDimensions.charAt(i);
            if(!Character.isDigit(ch)){
                length=sum;
                sum=0;

            }
            else {
                int num=(ch-'0');
                sum=(sum*10)+num;

            }



        }

        breadth=sum;

        return (length*breadth);



    }

}
