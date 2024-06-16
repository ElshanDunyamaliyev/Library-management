package com.example.Library.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class AuthorDto {
    
    private String firstName;
    private String lastName;
    private Integer birthDate;

    private List<Book> books;
}
