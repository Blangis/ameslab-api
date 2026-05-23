package com.giselle.ameslab.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tratamientos_sustancias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoSustancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tratamiento_id", nullable = false)
    private Tratamiento tratamiento;

    @ManyToOne
    @JoinColumn(name = "sustancia_id", nullable = false)
    private Sustancia sustancia;

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal concentracion;

    @Column(nullable = false)
    private String unidad;
}