package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.Familiar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamiliarRepository extends JpaRepository<Familiar, Long> {
    @Query("SELECT fa " +
            "FROM Familiar fa " +
            "WHERE (:postulanteId is null OR (fa.postulante.id =:postulanteId))")
    List<Familiar> listar(@Param("postulanteId") Long postulanteId,
                          Pageable pageable);
}
