package com.example.bookmanager.service;

import com.example.bookmanager.dto.category.CategoryResponse;
import com.example.bookmanager.dto.category.CreateCategoryRequest;
import com.example.bookmanager.entity.Category;
import com.example.bookmanager.exception.ResourceNotFoundException;
import com.example.bookmanager.mapper.CategoryMapper;
import com.example.bookmanager.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest){
        Category category = categoryMapper.toEntity(createCategoryRequest);

        return categoryMapper.toDto(categoryRepository.save(category));
    }

    public List<CategoryResponse> getAllCategories(){
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }

    public CategoryResponse getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        return categoryMapper.toDto(category);
    }
}
