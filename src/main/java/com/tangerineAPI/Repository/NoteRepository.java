package com.tangerineAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tangerineAPI.Model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
}
