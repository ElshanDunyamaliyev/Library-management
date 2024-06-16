package com.example.Library.dto;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String description;
    private Integer totalPage;
    private Integer publishedYear;
}
