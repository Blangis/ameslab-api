package com.giselle.ameslab.service;

import com.giselle.ameslab.domain.Resultado;
import com.giselle.ameslab.domain.Tratamiento;
import com.giselle.ameslab.dto.dashboard.DashboardSummaryInfoDTO;
import com.giselle.ameslab.exception.ResourceNotFoundException;
import com.giselle.ameslab.repository.ResultadoRepository;
import com.giselle.ameslab.repository.TratamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final ResultadoRepository resultadoRepository;
    private final TratamientoRepository tratamientoRepository;

    public DashboardService(
            ResultadoRepository resultadoRepository,
            TratamientoRepository tratamientoRepository
    ) {
        this.resultadoRepository = resultadoRepository;
        this.tratamientoRepository = tratamientoRepository;
    }

    public DashboardSummaryInfoDTO resumenPorTratamiento(Long tratamientoId) {

        Tratamiento tratamiento = tratamientoRepository.findById(tratamientoId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Tratamiento con id: " + tratamientoId + " no encontrado."
                ));

        List<Resultado> resultados =
                resultadoRepository.findByTratamientoId(tratamientoId);

        return construirResumen(tratamiento, resultados);
    }

    public List<DashboardSummaryInfoDTO> resumenPorTipoTratamiento(Long tipoTratamientoId) {

        List<Resultado> resultados = resultadoRepository
                .findByTratamientoTipoTratamientoId(tipoTratamientoId);

        return resultados.stream()
                .collect(Collectors.groupingBy(Resultado::getTratamiento))
                .entrySet()
                .stream()
                .map(entry ->
                        construirResumen(entry.getKey(), entry.getValue())
                )
                .toList();
    }

    private DashboardSummaryInfoDTO construirResumen(
            Tratamiento tratamiento,
            List<Resultado> resultados
    ) {

        int n = resultados.size();

        double promedio = resultados.stream()
                .mapToInt(Resultado::getRevertantes)
                .average()
                .orElse(0.0);

        double sumaCuadrados = resultados.stream()
                .mapToDouble(resultado ->
                        Math.pow(resultado.getRevertantes() - promedio, 2)
                )
                .sum();

        double desviacionEstandar = n > 1
                ? Math.sqrt(sumaCuadrados / (n - 1))
                : 0.0;

        double errorEstandar = n > 0
                ? desviacionEstandar / Math.sqrt(n)
                : 0.0;

        return new DashboardSummaryInfoDTO(
                tratamiento.getConcentracion(),
                tratamiento.getUnidad(),
                promedio,
                desviacionEstandar,
                errorEstandar,
                n
        );
    }
}
