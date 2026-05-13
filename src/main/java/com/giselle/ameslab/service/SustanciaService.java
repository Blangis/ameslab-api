package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.dto.sustance.SustanciaRequestDTO;
import com.giselle.ameslab.dto.sustance.SustanciaResponseDTO;
import com.giselle.ameslab.mapper.SustanciaMapper;
import com.giselle.ameslab.repository.SustanciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SustanciaService {
    private final SustanciaRepository sustanciaRepository;

    public SustanciaService(SustanciaRepository sustanciaRepository){
        this.sustanciaRepository = sustanciaRepository;
    }

    public List<SustanciaResponseDTO> listarTodas(){
        return sustanciaRepository.findAll()
                .stream()
                .map(SustanciaMapper::toDto)
                .toList();
    }

    public SustanciaResponseDTO crear(SustanciaRequestDTO dto){
        Sustancia sustancia = SustanciaMapper.toEntity(dto);

        Sustancia sustanciaGuardada = sustanciaRepository.save(sustancia);
        return SustanciaMapper.toDto(sustanciaGuardada);
    }
}
