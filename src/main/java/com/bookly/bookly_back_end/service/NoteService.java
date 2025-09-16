package com.bookly.bookly_back_end.service;

import com.bookly.bookly_back_end.model.Note;
import com.bookly.bookly_back_end.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;


    public Note createNote(Note note) {
        return noteRepository.save(note);
    }


    public List<Note> getNotesByBookId(UUID bookId) {
        return noteRepository.findByBookId(bookId);
    }


    public Optional<Note> getNoteById(UUID id) {
        return noteRepository.findById(id);
    }

    public void deleteAll(){
        noteRepository.deleteAll();
    }

    public void deleteNoteById(UUID id) {
        noteRepository.deleteById(id);
    }
}
