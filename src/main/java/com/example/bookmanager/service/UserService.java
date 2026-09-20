package com.example.bookmanager.service;

import com.example.bookmanager.dto.user.CreateUserRequest;
import com.example.bookmanager.dto.user.UserResponse;
import com.example.bookmanager.entity.User;
import com.example.bookmanager.exception.ResourceAlreadyExistException;
import com.example.bookmanager.mapper.UserMapper;
import com.example.bookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse createUser(CreateUserRequest createUserRequest){
        User user = userMapper.toEntity(createUserRequest);

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResourceAlreadyExistException("Username already in use");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new ResourceAlreadyExistException("Email already in use");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toDto(userRepository.save(user));
    }

}
