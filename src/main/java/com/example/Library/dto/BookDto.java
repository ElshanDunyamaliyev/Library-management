package com.example.Library.dto;

import com.example.Library.entity.Publisher;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private String description;
    private Integer totalPage;
    private Integer publishedYear;
    private CategoryDto category;
    private AuthorDto author;
    private PublisherDto publisher;
}
