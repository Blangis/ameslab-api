package com.giselle.ameslab.dto.treatment;

import java.math.BigDecimal;

public record TratamientoSummaryDTO(
        Long id,
        String nombre,
        String sustanciaNombre,
        String tipoTratamientoNombre,
        BigDecimal concentracion,
        String unidad
) {
}
