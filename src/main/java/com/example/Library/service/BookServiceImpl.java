package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import com.example.Library.mapper.BookMapper;
import com.example.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService{

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

//    @Transactional
    public void saveBook(BookDto bookDto) {
        Book bookEntity = bookMapper.mapToEntity(bookDto);
        bookRepository.save(bookEntity);
    }

//    @Transactional
    public Book updateBookById(Long bookId,BookDto bookDto) {
        Book bookEntity = bookRepository.findById(bookId).orElseThrow();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDescription(bookDto.getDescription());
        bookEntity.setTotalPage(bookDto.getTotalPage());
        bookEntity.setPublishedYear(bookDto.getPublishedYear());
        return bookRepository.save(bookEntity);
    }

//    @Transactional
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
