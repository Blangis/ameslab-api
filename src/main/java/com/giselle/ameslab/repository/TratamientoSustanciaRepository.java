package com.giselle.ameslab.repository;

import com.giselle.ameslab.domain.TratamientoSustancia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TratamientoSustanciaRepository extends JpaRepository<TratamientoSustancia, Long> {

    List<TratamientoSustancia> findByTratamientoId(Long tratamientoId);
}