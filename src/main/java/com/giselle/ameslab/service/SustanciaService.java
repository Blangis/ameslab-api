package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.dto.substance.SustanciaRequestDTO;
import com.giselle.ameslab.dto.substance.SustanciaResponseDTO;
import com.giselle.ameslab.exception.DuplicateResourceException;
import com.giselle.ameslab.exception.ResourceNotFoundException;
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
        if (sustanciaRepository.existsByNombre(dto.nombre())) {
            throw new DuplicateResourceException("Ya existe una sustancia con el nombre: " + dto.nombre());
        }

        Sustancia sustanciaGuardada = sustanciaRepository.save(sustancia);
        return SustanciaMapper.toDto(sustanciaGuardada);
    }

    public SustanciaResponseDTO verSustancia(Long id){
        Sustancia sustancia = sustanciaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Sustancia con id: "+id+ " no encontrada."));

        return SustanciaMapper.toDto(sustancia);

    }

    public void borrarSustancia(Long id){
        if(!sustanciaRepository.existsById(id)){
            throw new ResourceNotFoundException("Sustancia con id: "+id+ " no encontrada");
        }
        sustanciaRepository.deleteById(id);
    }

    public SustanciaResponseDTO editarSustancia(Long id, SustanciaRequestDTO dto){
        Sustancia sustancia = sustanciaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Sustancia con id: "+id+ " no encontrada."));

            if(dto.nombre() != null) {
                sustancia.setNombre(dto.nombre());
            }

            if(dto.tipo() != null){
                sustancia.setTipo(dto.tipo());
            }

            if(dto.descripcion() != null){
                sustancia.setDescripcion(dto.descripcion());
            }

            Sustancia sustanciaActualizada = sustanciaRepository.save(sustancia);

           return SustanciaMapper.toDto(sustanciaActualizada);

    }


}
