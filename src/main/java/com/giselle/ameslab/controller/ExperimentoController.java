package com.giselle.ameslab.controller;

import com.giselle.ameslab.dto.experiment.ExperimentoRequestDTO;
import com.giselle.ameslab.dto.experiment.ExperimentoResponseDTO;
import com.giselle.ameslab.service.ExperimentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experimento")
public class ExperimentoController {
    private final ExperimentoService experimentoService;

    public ExperimentoController(ExperimentoService experimentoService){
        this.experimentoService = experimentoService;
    }

    @GetMapping
    public List<ExperimentoResponseDTO> listarExperimentos(){
        return experimentoService.listaExperimentos();
    }

    @GetMapping("/{id}")
    public ExperimentoResponseDTO verExperimento(@PathVariable Long id){
        return experimentoService.verExperimento(id);
    }

    @PostMapping
    public ExperimentoResponseDTO crearExperimento(@RequestBody @Valid ExperimentoRequestDTO dto){
        return experimentoService.crearExperimento(dto);
    }

    @PutMapping("/{id}")
    public ExperimentoResponseDTO editarExperimento(@PathVariable Long id, @RequestBody @Valid ExperimentoRequestDTO dto){
        return experimentoService.editarExperimento(id, dto);
    }

    @DeleteMapping("/{id}")
    public void borrarExperimento(@PathVariable Long id){
        experimentoService.borrarExperimento(id);
    }
}
