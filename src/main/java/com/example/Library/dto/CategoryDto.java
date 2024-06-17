package com.example.Library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CategoryDto {

    private String categoryName;
    private Set<Book> books;

}
