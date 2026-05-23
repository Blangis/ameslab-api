package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.dto.substance.SustanciaSummaryDTO;
import com.giselle.ameslab.dto.treatment.TratamientoRequestDTO;
import com.giselle.ameslab.dto.treatment.TratamientoResponseDTO;
import com.giselle.ameslab.dto.treatment.TratamientoSummaryDTO;
import com.giselle.ameslab.dto.treatment.TratamientoSustanciaResponseDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoSummaryDTO;

import java.util.List;

public class TratamientoMapper {

    public static Tratamiento toEntity(
            TipoTratamiento tipoTratamiento,
            String descripcion
    ) {
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setTipoTratamiento(tipoTratamiento);
        tratamiento.setDescripcion(descripcion);

        return tratamiento;
    }

    public static TratamientoResponseDTO toDto(Tratamiento tratamiento, List<TratamientoSustanciaResponseDTO> sustancias){
        return new TratamientoResponseDTO(
                tratamiento.getId(),
                tratamiento.getNombre(),

                new TipoTratamientoSummaryDTO(
                        tratamiento.getTipoTratamiento().getId(),
                        tratamiento.getTipoTratamiento().getNombre()
                ),

                tratamiento.getDescripcion(),
                sustancias
        );
    }

    public static TratamientoSummaryDTO toSummaryDto(Tratamiento tratamiento) {
        return new TratamientoSummaryDTO(
                tratamiento.getId(),
                tratamiento.getNombre(),
                tratamiento.getTipoTratamiento().getNombre()
        );
    }
}
