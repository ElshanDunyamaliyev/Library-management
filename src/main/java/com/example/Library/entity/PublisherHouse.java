package com.example.Library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "publisher_house")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherHouse extends BaseEntity{

}
