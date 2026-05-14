package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoRequestDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoResponseDTO;
import com.giselle.ameslab.mapper.TipoTratamientoMapper;
import com.giselle.ameslab.repository.TipoTratamientoRepository;

import java.util.List;

public class TipoTratamientoService {
    private final TipoTratamientoRepository tipoTratamientoRepository;

    public TipoTratamientoService(TipoTratamientoRepository tipoTratamientoRepository){
        this.tipoTratamientoRepository = tipoTratamientoRepository;
    }

    public List<TipoTratamientoResponseDTO> traerTipos(){
        return tipoTratamientoRepository.findAll()
                .stream()
                .map(TipoTratamientoMapper::toDto)
                .toList();

    }

    public TipoTratamientoResponseDTO traerTipoTratamiento(Long id){
        TipoTratamiento tipoTratamiento = tipoTratamientoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tipo de tratamiento no encontrado."));

        return TipoTratamientoMapper.toDto(tipoTratamiento);
    }

    public TipoTratamientoResponseDTO crearTipoTratamiento(TipoTratamientoRequestDTO dto){
        TipoTratamiento tipoTratamiento = TipoTratamientoMapper.toEntity(dto);
        TipoTratamiento tipoTratamientoGuardado = tipoTratamientoRepository.save(tipoTratamiento);

        return TipoTratamientoMapper.toDto(tipoTratamientoGuardado);
    }
}
