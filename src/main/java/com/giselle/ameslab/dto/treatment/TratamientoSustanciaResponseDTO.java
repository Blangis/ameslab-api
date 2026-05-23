package com.giselle.ameslab.dto.treatment;

import java.math.BigDecimal;

public record TratamientoSustanciaResponseDTO(
        Long sustanciaId,
        String sustanciaNombre,
        BigDecimal concentracion,
        String unidad
) {
}
