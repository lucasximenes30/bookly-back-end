package com.bookly.bookly_back_end.controller;

import com.bookly.bookly_back_end.model.CollectionBooks;
import com.bookly.bookly_back_end.service.CollectionBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("collections")
public class CollectionBooksController {

    @Autowired
    public CollectionBooksService collectionBooksService;

    @PostMapping
    public ResponseEntity<CollectionBooks> createCollection(@RequestBody CollectionBooks collection) {
        return ResponseEntity.ok(collectionBooksService.createCollection(collection));
    }

    @GetMapping
    public ResponseEntity<List<CollectionBooks>> getAllCollections() {
        return ResponseEntity.ok(collectionBooksService.getAllCollections());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionBooks> getCollectionById(@PathVariable UUID id) {
        return ResponseEntity.ok(collectionBooksService.getCollectionById(id));
    }

    @PostMapping("/{collectionId}/books/{bookId}")
    public ResponseEntity<CollectionBooks> addBookToCollection(@PathVariable UUID collectionId,
                                                               @PathVariable UUID bookId) {
        return ResponseEntity.ok(collectionBooksService.addBookToCollection(collectionId, bookId));
    }

    @DeleteMapping("/{collectionId}/books/{bookId}")
    public ResponseEntity<CollectionBooks> removeBookFromCollection(@PathVariable UUID collectionId,
                                                                    @PathVariable UUID bookId) {
        return ResponseEntity.ok(collectionBooksService.removeBookFromCollection(collectionId, bookId));
    }
}
