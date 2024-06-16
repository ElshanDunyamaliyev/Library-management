package com.example.Library.controller;

import com.example.Library.dto.AuthorDto;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.service.AuthorService;
import com.example.Library.service.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorDto authorDto) {
        authorService.saveAuthor(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Author created successfully");
    }
}
