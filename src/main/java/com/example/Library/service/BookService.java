package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import com.example.Library.entity.Category;
import com.example.Library.mapper.BookMapper;
import com.example.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll(PageRequest.of(0,5)).stream().map(bookMapper::mapToDto).collect(Collectors.toList());
    }

    public List<BookDto> getBookByTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(bookMapper::mapToDto).collect(Collectors.toList());
    }

    public BookDto getBookById(Long bookId) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow();
        return bookMapper.mapToDto(bookEntity);
    }

    @Transactional
    public Book saveBook(BookDto bookDto) {
        Book bookEntity = bookMapper.mapToEntity(bookDto);
        return bookRepository.save(bookEntity);
    }

    @Transactional
    public Book updateBook(Long bookId,BookDto bookDto) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setPublishedYear(bookDto.getPublishedYear());
//        bookEntity.setLastReadPage(bookDto.getLastReadPage());
        return bookRepository.save(bookEntity);
    }

    @Transactional
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
