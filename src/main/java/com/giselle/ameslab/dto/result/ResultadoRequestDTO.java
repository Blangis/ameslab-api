package com.giselle.ameslab.dto.result;

import jakarta.validation.constraints.NotNull;

public record ResultadoRequestDTO(
        @NotNull
        Long experimentoId,

        @NotNull
        Long tratamientoId,

        @NotNull
        Integer replica,

        @NotNull
        Integer revertantes,

        String observaciones
) {
}
