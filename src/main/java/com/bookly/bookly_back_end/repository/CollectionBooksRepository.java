package com.bookly.bookly_back_end.repository;

import com.bookly.bookly_back_end.model.CollectionBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CollectionBooksRepository extends JpaRepository<CollectionBooks, UUID> {
}
