package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import com.example.Library.mapper.BookMapper;
import com.example.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::mapToDto).collect(Collectors.toList());
    }

    public BookDto getBookById(Long bookId) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow();
        return bookMapper.mapToDto(bookEntity);
    }

    public Book addBook(BookDto bookDto) {
        Book bookEntity = bookMapper.mapToEntity(bookDto);
        return bookRepository.save(bookEntity);
    }

    public Book updateBook(Long bookId,BookDto bookDto) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setPublishedYear(bookDto.getPublishedYear());
        return bookRepository.save(bookEntity);
    }

    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
