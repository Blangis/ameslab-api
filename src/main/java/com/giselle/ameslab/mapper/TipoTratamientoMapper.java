package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoRequestDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoResponseDTO;

public class TipoTratamientoMapper {
    public static TipoTratamiento toEntity(TipoTratamientoRequestDTO dto){
        TipoTratamiento tipoTratamiento = new TipoTratamiento();
        tipoTratamiento.setNombre(dto.nombre());
        tipoTratamiento.setDescripcion(dto.descripcion());

        return tipoTratamiento;
    }

    public static TipoTratamientoResponseDTO toDto(TipoTratamiento tpo_trat){
        return new TipoTratamientoResponseDTO(
                tpo_trat.getId(),
                tpo_trat.getNombre(),
                tpo_trat.getDescripcion()
        );
    }
}
