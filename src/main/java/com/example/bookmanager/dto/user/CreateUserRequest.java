package com.example.bookmanager.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    @NotBlank(message = "El usuario no puede estar vacío")
    private String username;

    @NotBlank(message = "El email no puede estar vacío")
    @Email
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 3, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;
}
