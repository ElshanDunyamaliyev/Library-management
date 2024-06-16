package com.example.Library.dto;

import com.example.Library.enums.CategoryType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CategoryDto {

    private String categoryName;
    private List<Book> books;

}
