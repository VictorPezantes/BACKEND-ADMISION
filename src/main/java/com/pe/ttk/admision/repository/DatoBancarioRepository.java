package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.DatoBancario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DatoBancarioRepository extends JpaRepository<DatoBancario,Long> {
    @Query("SELECT db " +
            "FROM DatoBancario db " +
            "WHERE (:postulanteId is null OR (db.postulante.id =:postulanteId))")
    List<DatoBancario> listar(@Param("postulanteId") Long postulanteId,
                              Pageable pageable);
}
