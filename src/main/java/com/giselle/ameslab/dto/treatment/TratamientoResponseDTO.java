package com.giselle.ameslab.dto.treatment;

import com.giselle.ameslab.dto.substance.SustanciaSummaryDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoSummaryDTO;
import java.math.BigDecimal;

public record TratamientoResponseDTO(
        Long id,
        SustanciaSummaryDTO sustancia,
        TipoTratamientoSummaryDTO tipoTratamiento,
        String nombre,
        BigDecimal concentracion,
        String unidad,
        String descripcion
) {

}
