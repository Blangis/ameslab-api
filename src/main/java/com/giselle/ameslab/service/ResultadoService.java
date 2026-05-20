package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.Experimento;
import com.giselle.ameslab.domain.Resultado;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.dto.result.ResultadoRequestDTO;
import com.giselle.ameslab.dto.result.ResultadoResponseDTO;
import com.giselle.ameslab.mapper.ResultadoMapper;
import com.giselle.ameslab.repository.ExperimentoRepository;
import com.giselle.ameslab.repository.ResultadoRepository;
import com.giselle.ameslab.repository.TratamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoService {
    private final ResultadoRepository resultadoRepository;
    private final ExperimentoRepository experimentoRepository;
    private final TratamientoRepository tratamientoRepository;

    public ResultadoService(ResultadoRepository resultadoRepository, ExperimentoRepository experimentoRepository, TratamientoRepository tratamientoRepository){
        this.resultadoRepository = resultadoRepository;
        this.experimentoRepository = experimentoRepository;
        this.tratamientoRepository = tratamientoRepository;
    }

    public List<ResultadoResponseDTO> listaResultados(){
        return resultadoRepository.findAll().stream()
                .map(ResultadoMapper::toDto).toList();
    }

    public ResultadoResponseDTO verResultado(Long id){
        Resultado resultado = resultadoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Resultado no encontrado."));

        return ResultadoMapper.toDto(resultado);
    }

    public ResultadoResponseDTO crearResultado(ResultadoRequestDTO dto){
        Experimento experimento = experimentoRepository.findById(dto.experimentoId())
                .orElseThrow(()-> new RuntimeException("Experimento no encontrado."));

        Tratamiento tratamiento = tratamientoRepository.findById(dto.tratamientoId())
                .orElseThrow(()-> new RuntimeException("Tratamiento no encontrado."));

        Resultado resultado = ResultadoMapper.toEntity(dto, experimento, tratamiento);
        Resultado resultadoGuardado = resultadoRepository.save(resultado);

        return ResultadoMapper.toDto(resultadoGuardado);
    }

    public ResultadoResponseDTO editarResultado(Long id, ResultadoRequestDTO dto){
        Resultado resultado = resultadoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Resultado no encontrado."));

        if(dto.experimentoId() != null){
            Experimento experimento = experimentoRepository.findById(dto.experimentoId())
                    .orElseThrow(()-> new RuntimeException("Experimento no tiene coincidencias."));

            resultado.setExperimento(experimento);
        }

        if(dto.tratamientoId() != null){
            Tratamiento tratamiento = tratamientoRepository.findById(dto.tratamientoId())
                    .orElseThrow(()-> new RuntimeException("Tramiento no tiene coincidencias"));

            resultado.setTratamiento(tratamiento);

        }

        if(dto.replica() != null){
            resultado.setReplica(dto.replica());
        }

        if(dto.revertantes() != null){
            resultado.setRevertantes(dto.revertantes());
        }

        if(dto.observaciones() != null){
            resultado.setObservaciones(dto.observaciones());
        }

        Resultado resultadoModificado = resultadoRepository.save(resultado);
        return ResultadoMapper.toDto(resultadoModificado);


    }

    public void eliminarResultado(Long id){
        Resultado resultado = resultadoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Resultado no encontrado"));

        resultadoRepository.delete(resultado);
    }
}
