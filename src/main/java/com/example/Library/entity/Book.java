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

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "total_page")
    private Integer totalPage;
    @Column(name = "published_year")
    private Integer publishedYear;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
