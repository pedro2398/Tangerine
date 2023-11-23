package com.tangerineAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tangerineAPI.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
}
