package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.entity.master.CentroMedico;
import com.pe.ttk.admision.enums.CentroMedicoNombre;

import java.util.Optional;

public interface CentroMedicoService {
    Optional<Integer> findAllByCentroMedicoNombre(CentroMedicoNombre centroMedicoNombre);
    void save(CentroMedico centroMedico);
}
