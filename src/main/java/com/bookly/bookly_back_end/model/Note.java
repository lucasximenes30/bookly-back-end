package com.bookly.bookly_back_end.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Note {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();
}
