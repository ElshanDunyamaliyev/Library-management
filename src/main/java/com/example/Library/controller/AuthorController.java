package com.example.Library.controller;

import com.example.Library.dto.AuthorDto;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Author in Library Application",
        description = "CRUD REST APIs in Library Application to CREATE, UPDATE, FETCH AND DELETE author details"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    @Operation(
            summary = "Fetch Author Details REST API",
            description = "REST API to fetch Author"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ResourceNotFoundException.class)
                    )
            )
    })
    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @Operation(
            summary = "Add Author",
            description = "REST API to create Author"
    )
    @PostMapping
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorDto authorDto) {
        authorService.saveAuthor(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Author created successfully");
    }

    @Operation(
            summary = "Update Author",
            description = "REST API to update Author"
    )
    @PutMapping("/{authorId}")
    public void updateAuthor(@PathVariable Long authorId, @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(authorId,authorDto);
    }

    @Operation(
            summary = "Update Author",
            description = "REST API to update Author"
    )
    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthorById(authorId);
    }
}
