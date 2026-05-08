package com.giselle.ameslab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="experimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fecha;
    private String cepa;
    private String descripcion;

}
