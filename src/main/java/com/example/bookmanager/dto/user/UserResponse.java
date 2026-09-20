package com.example.bookmanager.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String username;
    private String email;
}
