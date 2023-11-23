package com.tangerineAPI.dto;

import java.time.LocalDate;
import com.tangerineAPI.model.Note;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteDTO {
    private Long id;

    private String title;

    private String text;

    private LocalDate date;

    private Long userId;

    public NoteDTO(Note note) {
        id = note.getId();
        title = note.getTitle();
        text = note.getText();
        date = note.getDate();
        userId = note.getUser().getId();
    }
}
