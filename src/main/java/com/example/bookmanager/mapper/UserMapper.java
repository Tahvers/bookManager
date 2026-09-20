package com.example.bookmanager.mapper;

import com.example.bookmanager.dto.user.CreateUserRequest;
import com.example.bookmanager.dto.user.UserResponse;
import com.example.bookmanager.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity (CreateUserRequest createUserRequest){
        User user = new User();

        user.setUsername(createUserRequest.getUsername());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());

        return user;
    }

    public UserResponse toDto(User user){
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }
}
