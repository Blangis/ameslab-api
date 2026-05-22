package com.giselle.ameslab.controller;

import com.giselle.ameslab.dto.dashboard.DashboardSummaryInfoDTO;
import com.giselle.ameslab.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/tratamientos/{tratamientoId}/resumen")
    public DashboardSummaryInfoDTO resumenPorTratamiento(@PathVariable Long tratamientoId) {
        return dashboardService.resumenPorTratamiento(tratamientoId);
    }

    @GetMapping("/tipos-tratamiento/{tipoTratamientoId}/resumen")
    public List<DashboardSummaryInfoDTO> resumenPorTipoTratamiento(
            @PathVariable Long tipoTratamientoId
    ) {
        return dashboardService.resumenPorTipoTratamiento(tipoTratamientoId);
    }
}
