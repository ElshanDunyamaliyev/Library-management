package com.example.Library.dto;

import com.example.Library.entity.Category;
import com.example.Library.enums.BookStatus;
import lombok.Data;

import java.io.File;

@Data
public class BookDto {
    private String title;
    private String description;
    private Integer totalPage;
    private Integer publishedYear;
    private Long publisherId;
    private Long categoryId;
    private Long authorId;

//    private Integer lastReadPage;
//    private BookStatus bookStatus;
}
