package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import com.example.Library.entity.Category;
import com.example.Library.mapper.BookMapper;
import com.example.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CategoryService categoryService;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::mapToDto).collect(Collectors.toList());
    }

    public BookDto getBookById(Long bookId) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow();
        return bookMapper.mapToDto(bookEntity);
    }

    @Transactional
    public Book saveBook(BookDto bookDto) {
        Book bookEntity = bookMapper.mapToEntity(bookDto);
        Category category = categoryService.getCategoryById(bookEntity.getCategory().getId());
        bookEntity.setCategory(category);
        return bookRepository.save(bookEntity);
    }

    @Transactional
    public Book updateBook(Long bookId,BookDto bookDto) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setPublishedYear(bookDto.getPublishedYear());
        bookEntity.setLastReadPageNumber(bookDto.getLastReadPageNumber());
        return bookRepository.save(bookEntity);
    }

    @Transactional
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
