package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;

import java.util.List;

public interface AuthorService {

    public List<AuthorDto> findAll();
    public AuthorDto findById(Long id);
    public Author saveAuthor(AuthorDto authorDto);
    public void updateAuthorById(Long authorId,AuthorDto authorDto);
    public void deleteAuthorById(Long authorId);

}
