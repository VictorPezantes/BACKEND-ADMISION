package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.master.NivelEstudio;
import com.pe.ttk.admision.enums.NivelEstudioNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NivelEstudioRepository extends JpaRepository<NivelEstudio,Integer> {
    Optional<NivelEstudioNombre> findByNivelEstudioNombre(NivelEstudioNombre nivelEstudioNombre);
}