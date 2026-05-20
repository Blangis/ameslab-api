package com.giselle.ameslab.dto.treatment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TratamientoRequestDTO(
        @NotNull
        Long sustanciaId,

        @NotNull
        Long tipoTratamientoId,

        @NotNull
        @Positive
        BigDecimal concentracion,

        @NotNull
        String unidad,

        String descripcion) {
}
