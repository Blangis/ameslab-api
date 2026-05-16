package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.Experimento;
import com.giselle.ameslab.dto.experiment.ExperimentoRequestDTO;
import com.giselle.ameslab.dto.experiment.ExperimentoResponseDTO;

public class ExperimentoMapper {

    public static Experimento toEntity(ExperimentoRequestDTO dto){
        Experimento experimento = new Experimento();

        experimento.setNombre(dto.nombre());
        experimento.setDescripcion(dto.descripcion());
        experimento.setCepa(dto.cepa());
        experimento.setFecha(dto.fecha());

        return experimento;
    }

    public static ExperimentoResponseDTO toDto(Experimento experimento){
        return new ExperimentoResponseDTO(
                experimento.getId(),
                experimento.getNombre(),
                experimento.getFecha(),
                experimento.getCepa(),
                experimento.getDescripcion()

        );
    }

}
