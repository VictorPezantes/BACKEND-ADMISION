package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.TipoExamenNombre;

import java.util.Optional;

public interface TipoExamenService {
    Optional<TipoExamenNombre> findByTipoExamenNombre(TipoExamenNombre tipoExamenNombre);
    void save(TipoExamen tipoExamen);
}
