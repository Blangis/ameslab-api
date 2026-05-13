package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.dto.sustance.SustanciaRequestDTO;
import com.giselle.ameslab.dto.sustance.SustanciaResponseDTO;

public class SustanciaMapper {
    public static Sustancia toEntity(SustanciaRequestDTO dto){
        Sustancia sustancia= new Sustancia();

        sustancia.setNombre(dto.nombre());
        sustancia.setDescripcion(dto.descripcion());
        sustancia.setTipo(dto.tipo());

        return sustancia;

    }

    public static SustanciaResponseDTO toDto(Sustancia sustancia){
        return new SustanciaResponseDTO(
                sustancia.getId(),
                sustancia.getNombre(),
                sustancia.getDescripcion(),
                sustancia.getTipo()

                );

    }
}
