package com.example.Library.entity;

import com.example.Library.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

//    @Column(name = "last_read_page")
//    private Integer lastReadPage;
//    @Column(name = "book_status")
//    private BookStatus bookStatus;
}
