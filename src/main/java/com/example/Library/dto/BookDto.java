package com.example.Library.dto;

import com.example.Library.entity.Category;
import lombok.Data;

import java.io.File;

@Data
public class BookDto {
    private String title;
    private Integer totalPages;
    private Integer lastReadPageNumber;
    private Integer publishedYear;
    private File image;
    private Category category;
}
