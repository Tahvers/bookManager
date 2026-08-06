package com.example.bookmanager.dto.author;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAuthorRequest {
    @NotBlank(message = "El nombre del autor no puede estar vacío")
    private String name;
}
