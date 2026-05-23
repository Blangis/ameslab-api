package com.giselle.ameslab.dto.treatment;

import java.math.BigDecimal;

public record TratamientoSummaryDTO(
        Long id,
        String nombre,
        String tipoTratamientoNombre
) {
}
