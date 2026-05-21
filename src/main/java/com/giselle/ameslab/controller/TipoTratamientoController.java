package com.giselle.ameslab.controller;

import com.giselle.ameslab.dto.type_treatment.TipoTratamientoRequestDTO;
import com.giselle.ameslab.dto.type_treatment.TipoTratamientoResponseDTO;
import com.giselle.ameslab.service.TipoTratamientoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos_tratamientos")
public class TipoTratamientoController {
    private final TipoTratamientoService tipoTratamientoService;

    public TipoTratamientoController(TipoTratamientoService serv){
        this.tipoTratamientoService = serv;
    }

    @GetMapping
    public List<TipoTratamientoResponseDTO> traerTiposTratamiento(){
        return tipoTratamientoService.traerTipos();
    }

    @GetMapping("/{id}")
    public TipoTratamientoResponseDTO traerTipoTratamiento(@PathVariable Long id){
        return tipoTratamientoService.traerTipoTratamiento(id);
    }

    @PostMapping
    public TipoTratamientoResponseDTO crearTipoTrat(@RequestBody @Valid TipoTratamientoRequestDTO dto){
        return tipoTratamientoService.crearTipoTratamiento(dto);
    }

    @PutMapping("/{id}")
    public TipoTratamientoResponseDTO editarTipoTratamiento(@PathVariable Long id, @RequestBody @Valid TipoTratamientoRequestDTO dto){
        return tipoTratamientoService.editarTipoTratamiento(id, dto);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        tipoTratamientoService.borrarTipoTratamiento(id);
    }

}
