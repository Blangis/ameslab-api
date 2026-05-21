package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.dto.treatment.TratamientoRequestDTO;
import com.giselle.ameslab.dto.treatment.TratamientoResponseDTO;
import com.giselle.ameslab.exception.ResourceNotFoundException;
import com.giselle.ameslab.mapper.TratamientoMapper;
import com.giselle.ameslab.repository.SustanciaRepository;
import com.giselle.ameslab.repository.TipoTratamientoRepository;
import com.giselle.ameslab.repository.TratamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoService {
    private final TratamientoRepository tratamientoRepository;
    private final SustanciaRepository sustanciaRepository;
    private final TipoTratamientoRepository tipoTratamientoRepository;

    public TratamientoService(
            TratamientoRepository tratamientoRepository,
            SustanciaRepository sustanciaRepository,
            TipoTratamientoRepository tipoTratamientoRepository
    ) {
        this.tratamientoRepository = tratamientoRepository;
        this.sustanciaRepository = sustanciaRepository;
        this.tipoTratamientoRepository = tipoTratamientoRepository;
    }

    public List<TratamientoResponseDTO> traerTratamientos(){
        return tratamientoRepository.findAll().stream().map(TratamientoMapper::toDto).toList();
    }

    public TratamientoResponseDTO verTratamiento(Long id){
        Tratamiento tratamiento = tratamientoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Tratamiento con id: "+id+ " no encontrado"));

        return TratamientoMapper.toDto(tratamiento);
    }

    public TratamientoResponseDTO crearTratamiento(TratamientoRequestDTO dto){
        Sustancia sustancia = sustanciaRepository.findById(dto.sustanciaId())
                .orElseThrow(()-> new ResourceNotFoundException("Sustancia con id: "+dto.sustanciaId()+ " no existe."));

        TipoTratamiento tipoTratamiento = tipoTratamientoRepository.findById(dto.tipoTratamientoId())
                .orElseThrow(()-> new ResourceNotFoundException("Tipo de tratamiento con id: "+dto.tipoTratamientoId()+ " no encontrado."));

        Tratamiento tratamiento = TratamientoMapper.toEntity(dto, sustancia, tipoTratamiento);

        Tratamiento tratamientoGuardado = tratamientoRepository.save(tratamiento);
        return TratamientoMapper.toDto(tratamientoGuardado);
    }

    public TratamientoResponseDTO editarTratamiento(Long id, TratamientoRequestDTO dto){
       Tratamiento tratamiento = tratamientoRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Tratamiento con id: "+id+ " no encontrado"));

       if(dto.sustanciaId() != null){
           Sustancia sustancia = sustanciaRepository.findById(dto.sustanciaId())
                   .orElseThrow(()-> new ResourceNotFoundException("Sustancia con id: "+dto.sustanciaId()+ " no encontrada"));

           tratamiento.setSustancia(sustancia);

       }

       if(dto.tipoTratamientoId() != null){
           TipoTratamiento tipoTratamiento = tipoTratamientoRepository.findById(dto.tipoTratamientoId())
                   .orElseThrow(()-> new ResourceNotFoundException("Tipo de tratamiento con id: "+dto.tipoTratamientoId()+ " no encontrado."));

           tratamiento.setTipoTratamiento(tipoTratamiento);
       }



       if(dto.concentracion() != null){
           tratamiento.setConcentracion(dto.concentracion());
       }

       if(dto.unidad() != null){
           tratamiento.setUnidad(dto.unidad());
       }

       if(dto.descripcion() != null){
           tratamiento.setDescripcion(dto.descripcion());
       }

        tratamiento.setNombre(
                tratamiento.getSustancia().getNombre() + " - " +
                        tratamiento.getTipoTratamiento().getNombre()
        );

       Tratamiento tratamientoEditado = tratamientoRepository.save(tratamiento);

       return TratamientoMapper.toDto(tratamientoEditado);


    }

    public void eliminarTratamiento(Long id){
        Tratamiento tratamiento = tratamientoRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Tratamiento con id: "+id+ " no encontrado."));
        tratamientoRepository.delete(tratamiento);
    }
}
