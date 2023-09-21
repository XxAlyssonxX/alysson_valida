package com.projetodrograria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodrograria.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
