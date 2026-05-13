package com.giselle.ameslab.controller;

import com.giselle.ameslab.domain.Sustancia;
import com.giselle.ameslab.dto.sustance.SustanciaRequestDTO;
import com.giselle.ameslab.dto.sustance.SustanciaResponseDTO;
import com.giselle.ameslab.service.SustanciaService;
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
    public SustanciaResponseDTO crear(@RequestBody SustanciaRequestDTO dto){
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
    public SustanciaResponseDTO editarSustancia(@PathVariable Long id, @RequestBody SustanciaRequestDTO dto){
        return sustanciaService.editarSustancia(id, dto);
    }
}
