package com.bookly.bookly_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colecoes_de_livros")
public class CollectionBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "colecao_livros",
            joinColumns = @JoinColumn(name = "colecao_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private Set<Book> books = new HashSet<>();
}
