package com.example.Library.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PublisherDto {

    private String publisherName;

    private List<Book> books;
}
