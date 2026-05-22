package com.giselle.ameslab.repository;

import com.giselle.ameslab.domain.Resultado;
import com.giselle.ameslab.domain.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
    List<Resultado> findByTratamientoId(Long tratamientoId);
    List<Resultado> findByTratamientoTipoTratamientoId(Long tipoTratamientoId);
}
