package com.giselle.ameslab.dto.experiment;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ExperimentoRequestDTO(
        @NotBlank
        String nombre,

        LocalDate fecha,

        @NotBlank
        String cepa,

        String descripcion
) {
}
