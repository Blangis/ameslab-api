package com.giselle.ameslab.dto.treatment;

import java.math.BigDecimal;

public record TratamientoRequestDTO(
        Long sustanciaId,
        Long tipoTratamientoId,
        BigDecimal concentracion,
        String unidad,
        String descripcion) {
}
