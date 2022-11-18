package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.NivelEstudio;
import com.pe.ttk.admision.entity.master.TipoDatoAcademico;
import com.pe.ttk.admision.enums.NivelEstudioNombre;

import java.util.List;
import java.util.Optional;

public interface NivelEstudioService {
    Optional<NivelEstudioNombre> findByNivelEstudioNombre(NivelEstudioNombre nivelEstudioNombre);
    void save(NivelEstudio nivelEstudio);
    List<NivelEstudio> listar();
}
