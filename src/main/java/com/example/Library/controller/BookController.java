package com.example.Library.controller;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import com.example.Library.service.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;

    @Operation(
            summary = "Get All Books",
            description = "REST API to get all Books"
    )
    @GetMapping("/book")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @Operation(
            summary = "Get Book by title",
            description = "REST API to get books by title"
    )
    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> getBookByTitle(@RequestParam String title) {
        List<BookDto> books = bookService.getBookByTitle(title);
        return ResponseEntity.ok(books);
    }

    @Operation(
            summary = "Get Book by id",
            description = "REST API to get books by id"
    )
    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) {
        BookDto bookDto = bookService.getBookById(bookId);
        return ResponseEntity.ok(bookDto);
    }

    @Operation(
            summary = "Add Book",
            description = "REST API to create books"
    )
    @PostMapping("/book")
    public void saveBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
    }

    @Operation(
            summary = "Saving Book by category",
            description = "REST API to saving Book by category"
    )
    @PostMapping("/category/{categoryId}/book/{bookId}")
    public void saveBookByCategory(@PathVariable Long categoryId,@PathVariable Long bookId) {
        bookService.saveBookByCategory(categoryId, bookId);
    }

    @Operation(
            summary = "Saving Book by author",
            description = "REST API to saving Book by author"
    )
    @PostMapping("/author/{authorId}/book/{bookId}")
    public void saveBookByAuthor(@PathVariable Long authorId,@PathVariable Long bookId) {
        bookService.saveBookByAuthor(authorId, bookId);
    }

    @Operation(
            summary = "Updating Book by id",
            description = "REST API to Updating Book by id"
    )
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        Book updatedBook = bookService.updateBookById(bookId, bookDto);
        return ResponseEntity.ok(updatedBook);
    }

    @Operation(
            summary = "Deleting Book by id",
            description = "REST API to deleting Book by id"
    )
    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
