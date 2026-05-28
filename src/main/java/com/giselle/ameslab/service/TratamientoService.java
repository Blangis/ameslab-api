package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.domain.TipoTratamiento;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.domain.TratamientoSustancia;
import com.giselle.ameslab.dto.treatment.TratamientoRequestDTO;
import com.giselle.ameslab.dto.treatment.TratamientoResponseDTO;
import com.giselle.ameslab.dto.treatment.TratamientoSustanciaRequestDTO;
import com.giselle.ameslab.dto.treatment.TratamientoSustanciaResponseDTO;
import com.giselle.ameslab.exception.ResourceNotFoundException;
import com.giselle.ameslab.mapper.TratamientoMapper;
import com.giselle.ameslab.repository.SustanciaRepository;
import com.giselle.ameslab.repository.TipoTratamientoRepository;
import com.giselle.ameslab.repository.TratamientoRepository;
import com.giselle.ameslab.repository.TratamientoSustanciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TratamientoService {
    private final TratamientoRepository tratamientoRepository;
    private final SustanciaRepository sustanciaRepository;
    private final TipoTratamientoRepository tipoTratamientoRepository;
    private TratamientoSustanciaRepository tratamientoSustanciaRepository;

    public TratamientoService(
            TratamientoRepository tratamientoRepository,
            SustanciaRepository sustanciaRepository,
            TipoTratamientoRepository tipoTratamientoRepository,
            TratamientoSustanciaRepository tratamientoSustanciaRepository
    ) {
        this.tratamientoRepository = tratamientoRepository;
        this.sustanciaRepository = sustanciaRepository;
        this.tipoTratamientoRepository = tipoTratamientoRepository;
        this.tratamientoSustanciaRepository = tratamientoSustanciaRepository;
    }

    public TratamientoResponseDTO crearTratamiento(TratamientoRequestDTO dto){
        TipoTratamiento tipoTratamiento = tipoTratamientoRepository.findById(dto.tipoTratamientoId())
                .orElseThrow(()-> new ResourceNotFoundException("Tipo de tratamiento con id: "+ dto.tipoTratamientoId()+ " no encontrado."));

        Tratamiento tratamiento = TratamientoMapper.toEntity(tipoTratamiento, dto.descripcion());

        Tratamiento tratamientoGuardado = tratamientoRepository.save(tratamiento);

        List<TratamientoSustancia> detalles = dto.sustancias().stream()
                .map(detalleDto -> {
                    Sustancia sustancia = sustanciaRepository.findById(detalleDto.sustanciaId())
                            .orElseThrow(()-> new ResourceNotFoundException("Sustancia con id: " + detalleDto.sustanciaId() + "no encontrada."));

                            TratamientoSustancia detalle = new TratamientoSustancia();
                                    detalle.setTratamiento(tratamientoGuardado);
                                    detalle.setSustancia(sustancia);
                                    detalle.setConcentracion(detalleDto.concentracion());
                                    detalle.setUnidad(detalleDto.unidad());

                                    return tratamientoSustanciaRepository.save(detalle);
                })
                .toList();

        String nombre = generarNombre(tratamientoGuardado, detalles);
        tratamientoGuardado.setNombre(nombre);

        Tratamiento tratamientoConNombre = tratamientoRepository.save(tratamientoGuardado);

        List<TratamientoSustanciaResponseDTO> sustanciasResponse = detalles.stream()
                .map(this::toSustanciaResponse).toList();

        return TratamientoMapper.toDto(tratamientoConNombre, sustanciasResponse);
    }

    public List<TratamientoResponseDTO> listarTratamientos(){
        return tratamientoRepository.findAll()
                .stream()
                .map(tratamiento -> {
                    List<TratamientoSustancia> detalles = tratamientoSustanciaRepository.findByTratamientoId(tratamiento.getId());
                    List<TratamientoSustanciaResponseDTO> sustanciasResponse = detalles
                            .stream()
                            .map(this::toSustanciaResponse)
                            .toList();

                    return TratamientoMapper.toDto(tratamiento, sustanciasResponse);

                })
                .toList();
    }

    public TratamientoResponseDTO verTratamiento(Long id){
        Tratamiento tratamiento = tratamientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El tratamiento con id: " + id + " no se encuentra."));

        List<TratamientoSustancia> detalles = tratamientoSustanciaRepository.findByTratamientoId(tratamiento.getId());
        List<TratamientoSustanciaResponseDTO> sustanciasResponse = detalles.stream()
                .map(this::toSustanciaResponse)
                .toList();

        return TratamientoMapper.toDto(tratamiento,sustanciasResponse);
    }

    public void eliminarTratamiento(Long id){
        Tratamiento tratamiento = tratamientoRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Tratamiento con id: "+id+ " no encontrado."));

        List<TratamientoSustancia> detallesTratamientoSustancia = tratamientoSustanciaRepository.findByTratamientoId(tratamiento.getId());
        tratamientoSustanciaRepository.deleteAll(detallesTratamientoSustancia);
        tratamientoRepository.delete(tratamiento);
    }

    private TratamientoSustanciaResponseDTO toSustanciaResponse(TratamientoSustancia detalle){
        return new TratamientoSustanciaResponseDTO(
                detalle.getSustancia().getId(),
                detalle.getSustancia().getNombre(),
                detalle.getConcentracion(),
                detalle.getUnidad()
        );
    }

    private String generarNombre(Tratamiento tratamiento, List<TratamientoSustancia> detalles){
        String sustancias = detalles.stream()
                .map(detalle -> detalle.getSustancia().getNombre())
                .collect(Collectors.joining(" + "));

        return sustancias + " - " + tratamiento.getTipoTratamiento().getNombre();
    }
}
