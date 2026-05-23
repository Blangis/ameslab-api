package com.giselle.ameslab.dto.treatment;

import com.giselle.ameslab.dto.substance.SustanciaSummaryDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoSummaryDTO;
import java.math.BigDecimal;
import java.util.List;

public record TratamientoResponseDTO(
        Long id,
        String nombre,
        TipoTratamientoSummaryDTO tipoTratamiento,
        String descripcion,
        List<TratamientoSustanciaResponseDTO> sustancias
) {

}
