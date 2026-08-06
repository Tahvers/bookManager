package com.example.bookmanager.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequest {
    @NotBlank(message = "El nombre del autor no puede estar vacío")
    private String name;
}
