package com.tangerineAPI.model;
        
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SQ_NOTE", sequenceName = "SQ_NOTE", allocationSize = 1, initialValue = 1)
@Table(name = "TB_NOTE")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_NOTE")
    @Column(name = "ID_NOTE")
    private Long id;

    @NotBlank
    @Column(name = "NM_NOTE")
    private String title;
    
    @NotBlank
    @Column(name = "TXT_NOTE", nullable = false)
    private String text;
    
    @Column(name = "DT_NOTE")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(
        name = "ID_USER",
        referencedColumnName = "ID_USER",
        foreignKey = @ForeignKey(name = "FK_NOTE_USER")
    )
    private User user;
    
    //Adicionar um atributo para o BLOB das imgs
}
