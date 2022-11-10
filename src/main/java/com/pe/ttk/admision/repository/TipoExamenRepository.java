package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TipoExamenRepository extends JpaRepository<TipoExamen,Integer> {
    Optional<TipoExamenNombre> findByTipoExamenNombre(TipoExamenNombre tipoExamenNombre);
}
