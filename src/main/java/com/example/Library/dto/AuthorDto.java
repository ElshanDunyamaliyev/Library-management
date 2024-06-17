package com.example.Library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorDto {
    
    private String firstName;
    private String lastName;
    private Integer birthDate;

    private Set<Book> books;
}
