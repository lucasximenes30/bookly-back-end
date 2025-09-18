package com.bookly.bookly_back_end.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Livro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String isbn;

    private String title;

    private String authors;

    private String publisher;

    private String publishedDate;

    @Column(length = 2000)
    private String description;

    private boolean favorite;

    private String thumbnailUrl;

    @ManyToMany(mappedBy = "books")
    private Set<CollectionBooks> collections = new HashSet<>();

}
