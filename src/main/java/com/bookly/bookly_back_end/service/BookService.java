package com.bookly.bookly_back_end.service;


import com.bookly.bookly_back_end.model.Book;
import com.bookly.bookly_back_end.repository.BookRepository;
import com.bookly.bookly_back_end.response.GoogleBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public Book createBookFromIsbn(String isbn) {
        // se já existe, retorna
        Optional<Book> existing = bookRepository.findByIsbn(isbn);
        if (existing.isPresent()) {
            return existing.get();
        }

        // consulta a API do Google
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn;
        RestTemplate restTemplate = new RestTemplate();
        GoogleBookResponse response = restTemplate.getForObject(url, GoogleBookResponse.class);

        if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
            throw new RuntimeException("Livro não encontrado na Google Books API");
        }

        GoogleBookResponse.VolumeInfo info = response.getItems().get(0).getVolumeInfo();

        // cria entidade Book
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setIsbn(isbn);
        book.setTitle(info.getTitle());
        book.setAuthors(info.getAuthors() != null ? String.join(", ", info.getAuthors()) : null);
        book.setPublisher(info.getPublisher());
        book.setPublishedDate(info.getPublishedDate());
        book.setDescription(info.getDescription());
        book.setThumbnailUrl(info.getImageLinks() != null ? info.getImageLinks().getThumbnail() : null);

        return bookRepository.save(book);
    }
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
