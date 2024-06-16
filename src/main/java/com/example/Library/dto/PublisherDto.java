package com.example.Library.dto;

import com.example.Library.entity.Book;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PublisherDto {

    private String publisherName;

    private Set<BookDto> books;
}
