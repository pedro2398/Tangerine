package com.tangerineAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tangerineAPI.dto.NoteDTO;
import com.tangerineAPI.model.Note;
import com.tangerineAPI.repository.NoteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository repository;
    
    public NoteDTO getNotedById(Long id) {
        Note entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException();
        } );
        
        return new NoteDTO(entity);
    }
    
    public List<NoteDTO> getNote() {
        List<Note> entityes = repository.findAll();
        List<NoteDTO> dtos = new ArrayList<NoteDTO>();
        for(Note entity: entityes) {
            NoteDTO dto = new NoteDTO(entity);
            dtos.add(dto);
        }
    
        return dtos;
    }

    public void deleteById(Long id) {
        getNotedById(id);
        repository.deleteById(id);
    }

    public NoteDTO postNote(Note note) {
        note.setDate(LocalDate.now());
        repository.save(note);

        return new NoteDTO(note);
    }

    public NoteDTO putNote(Long id, Note newNote) {
        getNotedById(id);
        newNote.setId(id);
        repository.save(newNote);
     
        return new NoteDTO(newNote);
    }
}
