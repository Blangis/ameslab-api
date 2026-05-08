package com.giselle.ameslab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="resultados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="experimento_id")
    private Experimento experimento;

    @ManyToOne
    @JoinColumn(name="tratamiento_id")
    private Tratamiento tratamiento;

    private Integer replica;
    private Integer revertantes;
    private String observaciones;
}
