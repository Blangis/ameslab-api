package com.giselle.ameslab.dto.type_treatment;

import jakarta.validation.constraints.NotBlank;

public record TipoTratamientoRequestDTO(
        @NotBlank
        String nombre,

        @NotBlank
        String descripcion
) {
}
