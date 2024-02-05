package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String username, String password){

        User user=User.builder()
                .username(username)
                .password(password)
                .lastName(null)
                .firstName(null)
                .build();

        user =userRepository.save(user);
        return user;


    }

    public void deleteUser(int userId){

        //if(userRepository.findById(userId)==null)  return;

        Optional<User> user=userRepository.findById(userId);

        if(user.isEmpty()) return;

       userRepository.deleteById(userId);


    }

    public User updateUser(Integer id, String password){
        Optional<User> user1=userRepository.findById(id);

        if(user1.isEmpty()) return null;

      User  user=user1.get();

        user.setPassword(password);

        return user;

    }
}
