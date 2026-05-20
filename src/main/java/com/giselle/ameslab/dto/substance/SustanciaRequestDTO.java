package com.giselle.ameslab.dto.substance;

import jakarta.validation.constraints.NotBlank;

public record SustanciaRequestDTO(
        @NotBlank
        String nombre,

        String tipo,
        String descripcion
) {
}
