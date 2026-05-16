package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.dto.substance.SustanciaRequestDTO;
import com.giselle.ameslab.dto.substance.SustanciaResponseDTO;

public class SustanciaMapper {
    public static Sustancia toEntity(SustanciaRequestDTO dto){
        Sustancia sustancia= new Sustancia();

        sustancia.setNombre(dto.nombre());
        sustancia.setTipo(dto.tipo());
        sustancia.setDescripcion(dto.descripcion());

        return sustancia;

    }

    public static SustanciaResponseDTO toDto(Sustancia sustancia){
        return new SustanciaResponseDTO(
                sustancia.getId(),
                sustancia.getNombre(),
                sustancia.getTipo(),
                sustancia.getDescripcion()

                );

    }
}
