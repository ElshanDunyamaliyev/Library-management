package com.example.Library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher extends BaseEntity{

    @Column(name = "publisher_name")
    private String publisherName;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;
}
