package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.dto.entity.master.CentroMedico;
import com.pe.ttk.admision.enums.CentroMedicoNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CentroMedicoRepository extends JpaRepository<CentroMedico,Integer> {
    Optional<Integer> findAllByCentroMedicoNombre(CentroMedicoNombre centroMedicoNombre);
}
