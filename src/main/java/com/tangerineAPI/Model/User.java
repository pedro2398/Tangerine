package com.tangerineAPI.Model;

import java.util.LinkedHashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_USER", uniqueConstraints = {
    @UniqueConstraint(name = "UK_NM_USER", columnNames = "NM_USER")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USER")
    @SequenceGenerator(name = "SQ_USER", sequenceName = "SQ_USER", allocationSize = 1)
    @Column(name = "ID_USER")
    private Long id;

    @NotBlank
    @Column(name = "NM_USER", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "EMAIL_USER", nullable = false)
    private String email;

    @NotBlank
    @Column(name = "PWD_USER", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
        name = "TB_USER_NOTE",
        joinColumns = {
            @JoinColumn(
                name = "ID_USER",
                referencedColumnName = "ID_USER",
                foreignKey =  @ForeignKey(name = "FK_USER_NOTE")
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "ID_NOTE",
                referencedColumnName = "ID_NOTE",
                foreignKey = @ForeignKey(name = "FK_NOTE_USER")
            )
        }
    )
    private Set<Note> notes = new LinkedHashSet<>();
}
