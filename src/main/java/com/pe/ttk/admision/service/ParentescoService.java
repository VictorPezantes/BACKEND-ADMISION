package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.Parentesco;
import com.pe.ttk.admision.enums.ParentescoNombre;

import java.util.List;
import java.util.Optional;

public interface ParentescoService {

    Optional<ParentescoNombre> findAllByParentescoNombre(ParentescoNombre parentescoNombre);
    List<Parentesco> listar();
    void save(Parentesco parentesco);
}
