package com.giselle.ameslab.dto.dashboard;

import java.math.BigDecimal;

public record DashboardSummaryInfoDTO(
        BigDecimal concentracion,
        String unidad,
        Double promedioRevertantes,
        Double desviacionEstandar,
        Double errorEstandar,
        Integer numeroReplicas
) {
}
