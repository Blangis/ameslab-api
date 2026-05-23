package com.giselle.ameslab.dto.treatment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TratamientoSustanciaRequestDTO(

        @NotNull
        Long sustanciaId,

        @NotNull
        @Positive
        BigDecimal concentracion,

        @NotBlank
        String unidad
) {
}