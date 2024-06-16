package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        return authorMapper.mapToDto(authorRepository.findById(id).orElseThrow());
    }

    @Override
    public void saveAuthor(AuthorDto authorDto) {
        authorRepository.save(authorMapper.mapToEntity(authorDto));
    }

    @Override
    public void updateAuthorById(Long authorId,AuthorDto authorDto) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
