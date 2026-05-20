package com.giselle.ameslab.controller;

import com.giselle.ameslab.dto.substance.SustanciaRequestDTO;
import com.giselle.ameslab.dto.substance.SustanciaResponseDTO;
import com.giselle.ameslab.service.SustanciaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sustancias")
public class SustanciaController {
    private final SustanciaService sustanciaService;

    public SustanciaController (SustanciaService sustanciaService){
        this.sustanciaService = sustanciaService;
    }

    @GetMapping
    public List<SustanciaResponseDTO> listar(){
        return sustanciaService.listarTodas();
    }

    @PostMapping
    public SustanciaResponseDTO crear(@RequestBody @Valid SustanciaRequestDTO dto){
        return sustanciaService.crear(dto);
    }

    @GetMapping("/{id}")
    public SustanciaResponseDTO verSustancia(@PathVariable Long id){
       return sustanciaService.verSustancia(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarSustancia(@PathVariable Long id){
        sustanciaService.borrarSustancia(id);
    }

    @PutMapping("/{id}")
    public SustanciaResponseDTO editarSustancia(@PathVariable Long id, @RequestBody @Valid SustanciaRequestDTO dto){
        return sustanciaService.editarSustancia(id, dto);
    }
}
