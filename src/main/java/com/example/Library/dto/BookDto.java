package com.example.Library.dto;

import com.example.Library.entity.Publisher;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private String description;
    private Integer totalPage;
    private Integer publishedYear;
    private Category category;
    private Author author;
    private Publisher publisher;

    @Data
    public static class Category{
        private String categoryName;
    }

    @Data
    public static class Author{
        private String firstName;
        private String lastName;
        private Integer birthDate;
    }

    @Data
    public static class Publisher{
        private String publisherName;;
    }
}
