package com.giselle.ameslab.dto.treatment;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

// Representa el tratamiento completo que se manda desde front
public record TratamientoRequestDTO(
        @NotNull
        Long tipoTratamientoId,

        String descripcion,

        @Valid
        @NotEmpty
        List<TratamientoSustanciaRequestDTO> sustancias
){
}
