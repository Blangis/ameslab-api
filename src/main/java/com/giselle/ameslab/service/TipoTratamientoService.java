package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoRequestDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoResponseDTO;
import com.giselle.ameslab.mapper.TipoTratamientoMapper;
import com.giselle.ameslab.repository.TipoTratamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public TipoTratamientoResponseDTO editarTipoTratamiento(Long id, TipoTratamientoRequestDTO dto) {
        TipoTratamiento tipoTratamiento = tipoTratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de Tratamiento no encontrado"));

        if (dto.nombre() != null) {
            tipoTratamiento.setNombre(dto.nombre());
        }

        if (dto.descripcion() != null) {
            tipoTratamiento.setDescripcion(dto.descripcion());
        }
        TipoTratamiento tipoGuardado = tipoTratamientoRepository.save(tipoTratamiento);
        return TipoTratamientoMapper.toDto(tipoGuardado);
    }


    public void borrarTipoTratamiento(Long id){
        TipoTratamiento tipoTratamiento = tipoTratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ese tipo de tratamiento no existe"));

        tipoTratamientoRepository.delete(tipoTratamiento);

    }
}
