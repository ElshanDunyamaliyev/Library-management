package com.example.Library.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CategoryDto {
    @NotEmpty(message = "Category Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the category name should be between 5 and 30")
    private String categoryName;
    private Set<Book> books;

}
