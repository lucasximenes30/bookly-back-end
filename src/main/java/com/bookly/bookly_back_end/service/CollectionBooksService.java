package com.bookly.bookly_back_end.service;

import com.bookly.bookly_back_end.model.Book;
import com.bookly.bookly_back_end.model.CollectionBooks;
import com.bookly.bookly_back_end.repository.BookRepository;
import com.bookly.bookly_back_end.repository.CollectionBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CollectionBooksService {

    @Autowired
    public  CollectionBooksRepository collectionBooksRepository;
    @Autowired
    public  BookRepository bookRepository;



    public CollectionBooks createCollection(CollectionBooks collection) {
        return collectionBooksRepository.save(collection);
    }

    public List<CollectionBooks> getAllCollections() {
        return collectionBooksRepository.findAll();
    }

    public CollectionBooks getCollectionById(UUID id) {
        return collectionBooksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coleção não encontrada"));
    }

    public CollectionBooks addBookToCollection(UUID collectionId, UUID bookId) {
        CollectionBooks collection = getCollectionById(collectionId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        collection.getBooks().add(book);
        return collectionBooksRepository.save(collection);
    }

    public CollectionBooks removeBookFromCollection(UUID collectionId, UUID bookId) {
        CollectionBooks collection = getCollectionById(collectionId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        collection.getBooks().remove(book);
        return collectionBooksRepository.save(collection);
    }
}
