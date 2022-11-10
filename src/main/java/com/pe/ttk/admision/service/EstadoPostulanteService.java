package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.EstadoPostulante;
import com.pe.ttk.admision.enums.EstadoPostulanteNombre;

import java.util.List;
import java.util.Optional;

public interface EstadoPostulanteService {
    Optional<EstadoPostulanteNombre> findAllByEstadoPostulanteNombre(EstadoPostulanteNombre estadoPostulanteNombre);
    void save(EstadoPostulante estadoPostulante);
    Optional<EstadoPostulante> findById(Integer id);
    List<EstadoPostulante> listar();
}
