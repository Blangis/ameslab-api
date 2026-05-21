package com.giselle.ameslab.controller;

import com.giselle.ameslab.dto.treatment.TratamientoRequestDTO;
import com.giselle.ameslab.dto.treatment.TratamientoResponseDTO;
import com.giselle.ameslab.service.TratamientoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {
    private final TratamientoService tratamientoService;

    public TratamientoController (TratamientoService tratamientoService){
        this.tratamientoService = tratamientoService;
    }

    @GetMapping
    public List<TratamientoResponseDTO> listaTratamientos(){
        return tratamientoService.traerTratamientos();
    }

    @GetMapping("/{id}")
    public TratamientoResponseDTO verTratamiento(@PathVariable Long id){
        return tratamientoService.verTratamiento(id);
    }

    @PostMapping
    public TratamientoResponseDTO crearTratamiento(@RequestBody @Valid TratamientoRequestDTO dto){
        return tratamientoService.crearTratamiento(dto);
    }

    @PutMapping("/{id}")
    public TratamientoResponseDTO editarTratamiento(@PathVariable Long id, @RequestBody @Valid TratamientoRequestDTO dto){
        return tratamientoService.editarTratamiento(id, dto);
    }

    @DeleteMapping("/{id}")
    public void borrarTratamiento(@PathVariable Long id){
        tratamientoService.eliminarTratamiento(id);
    }
}
