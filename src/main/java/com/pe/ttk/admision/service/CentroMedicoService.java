package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.enums.CentroMedicoNombre;

import java.util.List;
import java.util.Optional;

public interface CentroMedicoService {
    Optional<CentroMedicoNombre> findAllByCentroMedicoNombre(CentroMedicoNombre centroMedicoNombre);
    void save(CentroMedico centroMedico);
    Optional<CentroMedico> findById(Integer id);
    List<CentroMedico> listar();
}
