package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.DatoEmbarque;
import com.pe.ttk.admision.entity.admision.DatoLaboral;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DatoLaboralRepository extends JpaRepository<DatoLaboral,Long> {
    @Query("SELECT dl " +
            "FROM DatoLaboral dl " +
            "WHERE (:postulanteId is null OR (dl.postulante.id =:postulanteId))")
    List<DatoLaboral> listar(@Param("postulanteId") Long postulanteId,
                              Pageable pageable);
}
