package com.example.Library.service.impl;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import com.example.Library.entity.Category;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.BookMapper;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.CategoryRepository;
import com.example.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll(PageRequest.of(0,5)).stream().map(bookMapper::mapToDto).collect(Collectors.toList());
    }

    public List<BookDto> getBookByTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(bookMapper::mapToDto).collect(Collectors.toList());
    }

    public BookDto getBookById(Long bookId) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        return bookMapper.mapToDto(bookEntity);
    }

    public void saveBook(BookDto bookDto) {
        Book bookEntity = bookMapper.mapToEntity(bookDto);
        bookRepository.save(bookEntity);
    }

    public void saveBookByCategory(Long categoryId, Long bookId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        Book bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        category.getBooks().add(bookEntity);
        bookEntity.setCategory(category);
        categoryRepository.save(category);
    }

    public void saveBookByAuthor(Long authorId, Long bookId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author Not Found"));
        Book bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        author.getBooks().add(bookEntity);
        bookEntity.setAuthor(author);
        authorRepository.save(author);
    }

    public Book updateBookById(Long bookId,BookDto bookDto) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDescription(bookDto.getDescription());
        bookEntity.setTotalPage(bookDto.getTotalPage());
        bookEntity.setPublishedYear(bookDto.getPublishedYear());
        return bookRepository.save(bookEntity);
    }

    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
