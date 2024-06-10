package com.example.Library.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity{

    private String title;
    private Integer totalPages;
    private Integer lastReadPageNumber;
    private Integer publishedYear;
    @OneToOne
    private PublisherHouse publisherHouse;
    @OneToOne
    private Image image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
