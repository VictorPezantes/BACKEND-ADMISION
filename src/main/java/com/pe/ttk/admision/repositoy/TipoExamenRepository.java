package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.dto.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoExamenRepository extends JpaRepository<TipoExamen,Integer> {
    Optional<TipoExamenNombre> findByTipoExamenNombre(TipoExamenNombre tipoExamenNombre);
}
