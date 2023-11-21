package com.tangerineAPI.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@SequenceGenerator(name = "SQ_USER", sequenceName = "SQ_USER", allocationSize = 1, initialValue = 1)
@Table(name = "TB_USER", uniqueConstraints = {
    @UniqueConstraint(name = "UK_USER_NM_USER", columnNames = "NM_USER"),
    @UniqueConstraint(name = "UK_USER_EMAIL_USER", columnNames = "EMAIL_USER"),
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USER")
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
}
