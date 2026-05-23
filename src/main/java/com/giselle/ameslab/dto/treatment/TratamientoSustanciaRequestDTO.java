package com.giselle.ameslab.dto.treatment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TratamientoSustanciaRequestDTO(

        @NotNull
        Long sustanciaId,

        String sustanciaNombre,

        @NotNull
        BigDecimal concentracion,

        @NotBlank
        String unidad
) {
}