package com.bookly.bookly_back_end.repository;


import com.bookly.bookly_back_end.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
    List<Note> findByBookId(UUID bookId);
}
