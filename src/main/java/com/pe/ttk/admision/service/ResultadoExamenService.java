package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.entity.master.ResultadoExamen;
import com.pe.ttk.admision.enums.ResultadoExamenNombre;
import java.util.Optional;

public interface ResultadoExamenService {
    Optional<ResultadoExamen> findByResultadoExamenNombre(ResultadoExamenNombre resultadoExamenNombre);
    void save(ResultadoExamen resultadoExamen);
}
