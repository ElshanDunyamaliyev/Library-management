package com.example.Library.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PublisherDto {

    @NotEmpty(message = "Publisher Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the publisher's first name should be between 5 and 30")
    private String publisherName;

    private Set<Book> books;
}
