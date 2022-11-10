package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.master.EstadoPostulante;
import com.pe.ttk.admision.enums.EstadoPostulanteNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoPostulanteRepository extends JpaRepository<EstadoPostulante,Integer> {
        Optional<EstadoPostulanteNombre> findAllByEstadoPostulanteNombre(EstadoPostulanteNombre estadoPostulanteNombre);
}