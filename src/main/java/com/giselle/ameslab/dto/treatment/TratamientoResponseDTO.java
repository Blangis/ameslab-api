package com.giselle.ameslab.dto.treatment;

import com.giselle.ameslab.dto.substance.SustanciaSummaryDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoSummaryDTO;
import java.math.BigDecimal;

public record TratamientoResponseDTO(
        Long id,
        TipoTratamientoSummaryDTO tipoTratamiento,
        String nombre,
        String descripcion,
        List<TratamientoSustanciaResponseDTO> sustancias
) {

}
