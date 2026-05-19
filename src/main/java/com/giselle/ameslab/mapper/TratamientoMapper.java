package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.dto.substance.SustanciaSummaryDTO;
import com.giselle.ameslab.dto.treatment.TratamientoRequestDTO;
import com.giselle.ameslab.dto.treatment.TratamientoResponseDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoSummaryDTO;

public class TratamientoMapper {

    public static Tratamiento toEntity(TratamientoRequestDTO dto, Sustancia sustancia, TipoTratamiento tipoTratamiento){
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setSustancia(sustancia);
        tratamiento.setTipoTratamiento(tipoTratamiento);
        tratamiento.setNombre(
                sustancia.getNombre() + " - " + tipoTratamiento.getNombre()
        );
        tratamiento.setConcentracion(dto.concentracion());
        tratamiento.setUnidad(dto.unidad());
        tratamiento.setDescripcion(dto.descripcion());

        return tratamiento;

    }

    public static TratamientoResponseDTO toDto(Tratamiento tratamiento){
        return new TratamientoResponseDTO(
                tratamiento.getId(),

                new SustanciaSummaryDTO(
                        tratamiento.getSustancia().getId(),
                        tratamiento.getSustancia().getNombre()
                ),

                new TipoTratamientoSummaryDTO(
                        tratamiento.getTipoTratamiento().getId(),
                        tratamiento.getTipoTratamiento().getNombre()
                ),

                tratamiento.getNombre(),
                tratamiento.getConcentracion(),
                tratamiento.getUnidad(),
                tratamiento.getDescripcion()
        );

    }
}
