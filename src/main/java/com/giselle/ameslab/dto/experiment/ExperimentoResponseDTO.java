package com.giselle.ameslab.dto.experiment;

import java.time.LocalDate;

public record ExperimentoResponseDTO(
        Long id,
        String nombre,
        LocalDate fecha,
        String cepa,
        String descripcion
) {
}
