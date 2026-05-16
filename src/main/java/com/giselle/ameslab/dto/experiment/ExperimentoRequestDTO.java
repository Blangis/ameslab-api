package com.giselle.ameslab.dto.experiment;

import java.time.LocalDate;

public record ExperimentoRequestDTO(
        String nombre,
        LocalDate fecha,
        String cepa,
        String descripcion
) {
}
