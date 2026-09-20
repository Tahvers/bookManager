package com.example.bookmanager.controller;

import com.example.bookmanager.dto.user.CreateUserRequest;
import com.example.bookmanager.dto.user.UserResponse;
import com.example.bookmanager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        UserResponse userResponse = userService.createUser(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
