package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.DatoEmbarque;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DatoEmbarqueRepository extends JpaRepository<DatoEmbarque,Long> {
    @Query("SELECT de " +
            "FROM DatoEmbarque de " +
            "WHERE (:postulanteId is null OR (de.postulante.id =:postulanteId))")
    List<DatoEmbarque> listar(@Param("postulanteId") Long postulanteId,
                                        Pageable pageable);
}
