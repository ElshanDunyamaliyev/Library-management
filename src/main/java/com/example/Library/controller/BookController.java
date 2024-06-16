package com.example.Library.controller;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import com.example.Library.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;

    @GetMapping("/book")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<BookDto>> searchByCategory(@RequestParam CategoryType categoryType) {
//        category.setCategoryType(categoryType);
//        List<BookDto> books = bookService.searchByCategory(category);
//        return ResponseEntity.ok(books);
//    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> getBookByTitle(@RequestParam String title) {
        List<BookDto> books = bookService.getBookByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) {
        BookDto bookDto = bookService.getBookById(bookId);
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping
    public void saveBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        Book updatedBook = bookService.updateBookById(bookId, bookDto);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
    }
}
