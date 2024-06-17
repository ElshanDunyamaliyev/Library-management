package com.example.Library.dto;

import com.example.Library.entity.Publisher;
import com.example.Library.enums.LoanStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

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
    private Set<Loan> loan;

    @Getter
    @Setter
    public static class Category{
        private String categoryName;
    }

    @Getter
    @Setter
    public static class Author{
        private String firstName;
        private String lastName;
        private Integer birthDate;
    }

    @Getter
    @Setter
    public static class Publisher{
        private String publisherName;;
    }

    @Getter
    @Setter
    public static class Loan{
        private LocalDateTime issueDate;
        private LocalDateTime dueDate;
        private LocalDateTime returnDate;
        private LoanStatus status;
    }
}
