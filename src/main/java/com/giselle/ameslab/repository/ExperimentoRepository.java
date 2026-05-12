package com.giselle.ameslab.repository;

import com.giselle.ameslab.domain.Experimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperimentoRepository extends JpaRepository<Experimento, Long> {
}
