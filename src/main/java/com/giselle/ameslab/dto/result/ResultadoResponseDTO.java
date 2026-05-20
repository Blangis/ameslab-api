package com.giselle.ameslab.dto.result;

import com.giselle.ameslab.dto.experiment.ExperimentoSummaryDTO;
import com.giselle.ameslab.dto.treatment.TratamientoSummaryDTO;

public record ResultadoResponseDTO(
        Long id,
        ExperimentoSummaryDTO experimento,
        TratamientoSummaryDTO tratamiento,
        Integer replica,
        Integer revertantes,
        String observaciones
) {
}
