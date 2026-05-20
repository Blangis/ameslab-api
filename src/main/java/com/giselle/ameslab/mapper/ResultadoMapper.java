package com.giselle.ameslab.mapper;

import com.giselle.ameslab.domain.Experimento;
import com.giselle.ameslab.domain.Resultado;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.dto.experiment.ExperimentoSummaryDTO;
import com.giselle.ameslab.dto.result.ResultadoRequestDTO;
import com.giselle.ameslab.dto.result.ResultadoResponseDTO;
import com.giselle.ameslab.dto.treatment.TratamientoSummaryDTO;

public class ResultadoMapper {
    public static Resultado toEntity(ResultadoRequestDTO dto, Experimento experimento, Tratamiento tratamiento){
        Resultado resultado = new Resultado();
        resultado.setExperimento(experimento);
        resultado.setTratamiento(tratamiento);
        resultado.setReplica(dto.replica());
        resultado.setRevertantes(dto.revertantes());
        resultado.setObservaciones(dto.observaciones());

        return resultado;
    }

    public static ResultadoResponseDTO toDto(Resultado resultado){
        return new ResultadoResponseDTO(
                resultado.getId(),

                new ExperimentoSummaryDTO(
                        resultado.getExperimento().getId(),
                        resultado.getExperimento().getNombre(),
                        resultado.getExperimento().getCepa()
                ),

                new TratamientoSummaryDTO(
                        resultado.getTratamiento().getId(),
                        resultado.getTratamiento().getNombre(),
                        resultado.getTratamiento().getSustancia().getNombre(),
                        resultado.getTratamiento().getTipoTratamiento().getNombre(),
                        resultado.getTratamiento().getConcentracion(),
                        resultado.getTratamiento().getUnidad()
                ),

                resultado.getReplica(),
                resultado.getRevertantes(),
                resultado.getObservaciones()

        );
    }
}
