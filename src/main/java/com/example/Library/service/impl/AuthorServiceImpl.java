package com.example.Library.service.impl;

import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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
        var authors = authorRepository.findAll(PageRequest.of(0,5)).stream().map(authorMapper::mapToDto).collect(Collectors.toList());
        log.info("ActionLog.getAllAuthors.end");
        return authors;
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        log.info("ActionLog.getAuthorById.start");
        var author = authorMapper.mapToDto(authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author Not Found")));
        log.info("ActionLog.getAuthorById.end");
        return author;
    }

    @Override
    public void saveAuthor(AuthorDto authorDto) {
        log.info("ActionLog.saveAuthor.start");
        authorRepository.save(authorMapper.mapToEntity(authorDto));
        log.info("ActionLog.saveAuthor.start");
    }

    @Override
    public void updateAuthorById(Long authorId,AuthorDto authorDto) {
        log.info("ActionLog.updateAuthorById.start");
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author Not Found"));
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        authorRepository.save(author);
        log.info("ActionLog.updateAuthorById.end");
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        log.info("ActionLog.deleteAuthorById.start");
        authorRepository.deleteById(authorId);
        log.info("ActionLog.deleteAuthorById.end");
    }
}
