package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.enums.CentroMedicoNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CentroMedicoRepository extends JpaRepository<CentroMedico,Integer> {
    Optional<CentroMedicoNombre> findAllByCentroMedicoNombre(CentroMedicoNombre centroMedicoNombre);
}
