package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.enums.EstadoResultadoExamenNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ResultadoExamenRepository extends JpaRepository<EstadoResultadoExamen, Integer> {
    Optional<EstadoResultadoExamenNombre> findByResultadoExamenNombre(EstadoResultadoExamenNombre resultadoExamenNombre);
}
