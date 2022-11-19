package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.DatoRedSocial;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DatoRedSocialRepository extends JpaRepository<DatoRedSocial,Long> {
    @Query("SELECT drs " +
            "FROM DatoRedSocial drs " +
            "WHERE (:postulanteId is null OR (drs.postulante.id =:postulanteId))")
    List<DatoRedSocial> listar(@Param("postulanteId") Long postulanteId,
                             Pageable pageable);
}
