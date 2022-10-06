package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.dto.entity.master.ResultadoExamen;
import com.pe.ttk.admision.enums.ResultadoExamenNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ResultadoExamenRepository extends JpaRepository<ResultadoExamen, Integer> {
    Optional<ResultadoExamen> findByResultadoExamenNombre(ResultadoExamenNombre resultadoExamenNombre);
}
