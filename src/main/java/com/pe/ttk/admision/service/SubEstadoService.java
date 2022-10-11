package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.enums.SubEstadoNombre;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface SubEstadoService {
    Optional<SubEstadoNombre> findBySubEstadoNombre(@NotNull SubEstadoNombre subEstadoNombre);
    void save(SubEstado subEstado);
}
