package com.tangerineAPI.controller;

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
import com.tangerineAPI.dto.NoteDTO;
import com.tangerineAPI.model.Note;
import com.tangerineAPI.service.NoteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    NoteService service;

    @GetMapping
    public List<NoteDTO> getNote() {
        System.out.println("All notes");
        return service.getNote();
    }

    @PostMapping
    public ResponseEntity<NoteDTO> postNote(@RequestBody @Valid Note note) {
        System.out.println("Signing up note"); 
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postNote(note));
    }

    @GetMapping( "{id}" )
    public ResponseEntity<NoteDTO> getNoteId(@PathVariable Long id) {
        System.out.println("Note with id: " + id);
        
        return ResponseEntity.ok(service.getNotedById(id));
    }

    @DeleteMapping( "{id}" )
    public ResponseEntity<Object> deleteNote(@PathVariable Long id) {
        System.out.println("Deleting note with id " + id);
        service.deleteById(id);
        
        return ResponseEntity.noContent().build();   
    }

    @PutMapping( "{id}" )
    public ResponseEntity<NoteDTO> putNote(@PathVariable Long id, @RequestBody @Valid Note newNote) {
        System.out.println("Changing note with id " + id);

        return ResponseEntity.ok(service.putNote(id, newNote));
    }
}