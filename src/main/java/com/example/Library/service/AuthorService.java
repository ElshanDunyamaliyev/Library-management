package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthors();
    AuthorDto getAuthorById(Long id);
    void saveAuthor(AuthorDto authorDto);
    void updateAuthorById(Long authorId,AuthorDto authorDto);
    void deleteAuthorById(Long authorId);

}
