package com.tangerineAPI.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    //Adicionar um atributo para o BLOB das imgs
}
