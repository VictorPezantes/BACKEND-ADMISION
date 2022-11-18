package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.DatoAcademico;
import com.pe.ttk.admision.entity.admision.Familiar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DatoAcademicoRepository extends JpaRepository<DatoAcademico,Long> {
    @Query("SELECT da " +
            "FROM DatoAcademico da " +
            "WHERE (:postulanteId is null OR (da.postulante.id =:postulanteId))")
    List<DatoAcademico> listar(@Param("postulanteId") Long postulanteId,
                          Pageable pageable);
}
