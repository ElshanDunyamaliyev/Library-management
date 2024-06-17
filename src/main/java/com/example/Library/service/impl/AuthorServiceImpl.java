package com.example.Library.service.impl;

import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> getAllAuthors() {
        log.info("ActionLog.getAllAuthors.start");
        return authorRepository.findAll().stream().map(authorMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        return authorMapper.mapToDto(authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author Not Found")));
    }

    @Override
    public void saveAuthor(AuthorDto authorDto) {
        authorRepository.save(authorMapper.mapToEntity(authorDto));
    }

    @Override
    public void updateAuthorById(Long authorId,AuthorDto authorDto) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author Not Found"));
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
