package com.pe.ttk.admision.service;

import com.pe.ttk.admision.entity.master.EstadoOferta;
import com.pe.ttk.admision.enums.EstadoOfertaNombre;

import java.util.List;
import java.util.Optional;

public interface EstadoOfertaService {

    List<EstadoOferta> listaEstados();

    void save(EstadoOferta estadoOferta);

    void eliminarEstado(Integer id);

    void actualizarEstado(Integer id, EstadoOferta estadoOferta);

    Optional<EstadoOferta> getOne(Integer id);

    Optional<EstadoOfertaNombre> findAllByEstadoOfertaNombre(EstadoOfertaNombre estadoOfertaNombre);
}
