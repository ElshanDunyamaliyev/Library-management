package com.example.Library.dto;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String description;
    private Integer totalPage;
    private Integer publishedYear;
    private Long publisherId;
    private Long categoryId;
    private Long authorId;
}
