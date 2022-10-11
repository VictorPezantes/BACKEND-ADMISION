package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.enums.ResultadoExamenNombre;
import java.util.Optional;

public interface ResultadoExamenService {
    Optional<ResultadoExamenNombre> findByResultadoExamenNombre(ResultadoExamenNombre resultadoExamenNombre);
    void save(EstadoResultadoExamen estadoResultadoExamen);
}
