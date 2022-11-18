package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.TipoDatoAcademico;
import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.TipoDatoAcademicoNombre;

import java.util.List;
import java.util.Optional;

public interface TipoDatoAcademicoService {
    Optional<TipoDatoAcademicoNombre> findByTipoDatoAcademicoNombre(TipoDatoAcademicoNombre tipoDatoAcademicoNombre);
    void save(TipoDatoAcademico tipoDatoAcademico);
    List<TipoDatoAcademico> listar();
}

