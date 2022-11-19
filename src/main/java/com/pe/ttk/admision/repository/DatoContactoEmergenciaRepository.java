package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.DatoAcademico;
import com.pe.ttk.admision.entity.admision.DatoContactoEmergencia;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DatoContactoEmergenciaRepository extends JpaRepository<DatoContactoEmergencia,Long> {
    @Query("SELECT dce " +
            "FROM DatoContactoEmergencia dce " +
            "WHERE (:postulanteId is null OR (dce.postulante.id =:postulanteId))")
    List<DatoContactoEmergencia> listar(@Param("postulanteId") Long postulanteId,
                               Pageable pageable);
}
