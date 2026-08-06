package com.example.bookmanager.service;

import com.example.bookmanager.dto.author.AuthorResponse;
import com.example.bookmanager.dto.author.CreateAuthorRequest;
import com.example.bookmanager.entity.Author;
import com.example.bookmanager.exception.ResourceNotFoundException;
import com.example.bookmanager.mapper.AuthorMapper;
import com.example.bookmanager.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorResponse createAuthor(CreateAuthorRequest createAuthorRequest){
        Author author = authorMapper.toEntity(createAuthorRequest);

        return authorMapper.toDto(authorRepository.save(author));
    }

    public List<AuthorResponse> getAllAuthors(){
        return authorRepository.findAll().stream().map(authorMapper::toDto).collect(Collectors.toList());
    }

    public AuthorResponse getAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        return authorMapper.toDto(author);
    }
}
