package com.bookly.bookly_back_end.controller;


import com.bookly.bookly_back_end.model.Book;
import com.bookly.bookly_back_end.model.Note;
import com.bookly.bookly_back_end.repository.NoteRepository;
import com.bookly.bookly_back_end.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    public BookService bookService;
    @Autowired
    public NoteRepository noteRepository;

    @PostMapping("/{isbn}")
    public Book createBook(@PathVariable String isbn) {
        return bookService.createBookFromIsbn(isbn);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.getAll();
    }

    @PostMapping("/{id}/notes")
    public Note addNote(@PathVariable UUID id, @RequestBody String content) {
        Note note = new Note();
        note.setBook(new Book());
        note.getBook().setId(id);
        note.setContent(content);
        return noteRepository.save(note);
    }

    @GetMapping("/{id}/notes")
    public List<Note> listNotes(@PathVariable UUID id) {
        return noteRepository.findByBookId(id);
    }
}
