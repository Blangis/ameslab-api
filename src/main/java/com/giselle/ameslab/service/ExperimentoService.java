package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.Experimento;
import com.giselle.ameslab.dto.experiment.ExperimentoRequestDTO;
import com.giselle.ameslab.dto.experiment.ExperimentoResponseDTO;
import com.giselle.ameslab.mapper.ExperimentoMapper;
import com.giselle.ameslab.repository.ExperimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentoService {
    private final ExperimentoRepository experimentoRepository;

    public ExperimentoService(ExperimentoRepository experimentoRepository){
        this.experimentoRepository = experimentoRepository;
    }

    public List<ExperimentoResponseDTO> listaExperimentos(){
        return experimentoRepository.findAll().stream().map(ExperimentoMapper::toDto)
                .toList();
    }

    public ExperimentoResponseDTO verExperimento(Long id){
        Experimento experimento = experimentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Experimento no encontrado."));

        return ExperimentoMapper.toDto(experimento);
    }

    public ExperimentoResponseDTO crearExperimento(ExperimentoRequestDTO dto){
        Experimento experimento = ExperimentoMapper.toEntity(dto);
        Experimento experimentoGuardado = experimentoRepository.save(experimento);

        return ExperimentoMapper.toDto(experimentoGuardado);

    }

    public ExperimentoResponseDTO editarExperimento(Long id, ExperimentoRequestDTO dto){
        Experimento experimento = experimentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Experimento no encontrado"));

        if(dto.nombre() != null){
            experimento.setNombre(dto.nombre());
        }

        if(dto.cepa() != null){
            experimento.setCepa(dto.cepa());
        }

        if(dto.fecha() != null){
            experimento.setFecha(dto.fecha());
        }

        if(dto.descripcion() != null){
            experimento.setDescripcion(dto.descripcion());
        }

        experimentoRepository.save(experimento);

        return ExperimentoMapper.toDto(experimento);

    }

    public void borrarExperimento(Long id){
         experimentoRepository.findById(id)
                 .orElseThrow(()-> new RuntimeException("Experimento no encontrado."));

         experimentoRepository.deleteById(id);
    }

    
}
