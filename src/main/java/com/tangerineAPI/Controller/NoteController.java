package com.tangerineAPI.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangerineAPI.Model.Note;
import com.tangerineAPI.Repository.NoteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    NoteRepository repository;

    @GetMapping
    public List<Note> getNote() {
        System.out.println("All notes");
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Note> postNote(@RequestBody @Valid Note note) {
        System.out.println("Signing up note"); 
        note.setDate(LocalDate.now());
        repository.save(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }

    @GetMapping( "{id}" )
    public ResponseEntity<Note> getNoteId(@PathVariable Long id) {
        System.out.println("Note with id: " + id);
        
        return ResponseEntity.ok(getNotedById(id));
    }

    @DeleteMapping( "{id}" )
    public ResponseEntity<Object> deleteNote(@PathVariable Long id) {
        System.out.println("Deleting note with id " + id);
        
        getNotedById(id);
        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();   
    }

    @PutMapping( "{id}" )
    public ResponseEntity<Note> putNote(@PathVariable Long id, @RequestBody @Valid Note newNote) {
        System.out.println("Changing note with id " + id);
        
        getNotedById(id);
        newNote.setId(id);
        repository.save(newNote);

        return ResponseEntity.ok(newNote);
    }

    private Note getNotedById(Long id) {
        return repository.findById(id).orElseThrow( () -> {
            return new RuntimeException();
        } );
    }
}