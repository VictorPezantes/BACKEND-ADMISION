package com.pe.ttk.admision.repository;


import com.pe.ttk.admision.entity.master.EstadoOferta;
import com.pe.ttk.admision.enums.EstadoOfertaNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoOfertaRepository extends JpaRepository<EstadoOferta, Integer> {
    Optional<EstadoOfertaNombre> findAllByEstadoOfertaNombre(EstadoOfertaNombre estadoOfertaNombre);
}
