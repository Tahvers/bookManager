package com.example.bookmanager.controller;

import com.example.bookmanager.dto.author.AuthorResponse;
import com.example.bookmanager.dto.author.CreateAuthorRequest;
import com.example.bookmanager.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest){
        AuthorResponse authorResponse = authorService.createAuthor(createAuthorRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(authorResponse);
    }

    @GetMapping
    public List<AuthorResponse> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping({"/{id}"})
    public AuthorResponse getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }
}
