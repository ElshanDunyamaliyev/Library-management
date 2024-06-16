package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.BookDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    void saveBook(BookDto bookDto);
    Book updateBookById(Long bookId,BookDto bookDto);
    void deleteBookById(Long bookId);
}
