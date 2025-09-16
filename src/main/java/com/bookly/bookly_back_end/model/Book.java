package com.bookly.bookly_back_end.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(unique = true, nullable = false)
    private String isbn;

    private String title;

    private String authors; // ex: "Autor 1, Autor 2"

    private String publisher;

    private String publishedDate;

    @Column(length = 2000)
    private String description;

    private String thumbnailUrl;
}
