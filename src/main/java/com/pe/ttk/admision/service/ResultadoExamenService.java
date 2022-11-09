package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.enums.EstadoResultadoExamenNombre;
import java.util.Optional;

public interface ResultadoExamenService {
    Optional<EstadoResultadoExamenNombre> findByResultadoExamenNombre(EstadoResultadoExamenNombre resultadoExamenNombre);
    void save(EstadoResultadoExamen estadoResultadoExamen);
}
