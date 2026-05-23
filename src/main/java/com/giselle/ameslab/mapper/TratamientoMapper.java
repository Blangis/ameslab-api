package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.dto.substance.SustanciaSummaryDTO;
import com.giselle.ameslab.dto.treatment.TratamientoRequestDTO;
import com.giselle.ameslab.dto.treatment.TratamientoResponseDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoSummaryDTO;

public class TratamientoMapper {

    public static Tratamiento toEntity(TratamientoRequestDTO dto,TipoTratamiento tipoTratamiento){
        Tratamiento tratamiento = new Tratamiento();

        tratamiento.setTipoTratamiento(tipoTratamiento);
        tratamiento.setDescripcion(dto.descripcion());
        tratamiento.setNombre(
                tipoTratamiento.getNombre()
        );

        return tratamiento;

    }

    public static TratamientoResponseDTO toDto(Tratamiento tratamiento){
        return new TratamientoResponseDTO(
                tratamiento.getId(),

                new TipoTratamientoSummaryDTO(
                        tratamiento.getTipoTratamiento().getId(),
                        tratamiento.getTipoTratamiento().getNombre()
                ),

                tratamiento.getNombre(),
                tratamiento.getDescripcion()
        );
    }
}
