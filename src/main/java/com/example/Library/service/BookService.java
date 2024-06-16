package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.BookDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;

import java.util.List;

public interface BookService {

    public List<BookDto> getAllBooks();
    public BookDto getBookById(Long id);
    public void saveBook(BookDto bookDto);
    public Book updateBookById(Long bookId,BookDto bookDto);
    public void deleteBookById(Long bookId);
}
