package com.example.Library.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorDto {

    @NotEmpty(message = "First Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the author's first name should be between 5 and 30")
    private String firstName;
    @NotEmpty(message = "Last Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the author's last name should be between 5 and 30")
    private String lastName;
    private Integer birthDate;
    private Set<Book> books;
}
