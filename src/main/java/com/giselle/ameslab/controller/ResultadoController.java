package com.giselle.ameslab.controller;

import com.giselle.ameslab.dto.result.ResultadoRequestDTO;
import com.giselle.ameslab.dto.result.ResultadoResponseDTO;
import com.giselle.ameslab.service.ResultadoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {
    private final ResultadoService resultadoService;

    public ResultadoController(ResultadoService resultadoService){
        this.resultadoService = resultadoService;
    }

    @GetMapping
    public List<ResultadoResponseDTO> listaResultados(){
        return resultadoService.listaResultados();
    }

    @GetMapping("/{id}")
    public ResultadoResponseDTO verResultado(@PathVariable Long id){
        return resultadoService.verResultado(id);
    }

    @PostMapping
    public ResultadoResponseDTO crearResultado(@Valid @RequestBody ResultadoRequestDTO dto){
        return resultadoService.crearResultado(dto);
    }

    @PutMapping("/{id}")
    public ResultadoResponseDTO editarResultado(@PathVariable Long id, @RequestBody ResultadoRequestDTO dto){
        return resultadoService.editarResultado(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarResultado(@PathVariable Long id){
        resultadoService.eliminarResultado(id);
    }
}
