package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.master.TipoDatoAcademico;
import com.pe.ttk.admision.enums.TipoDatoAcademicoNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoDatoAcademicoRepository extends JpaRepository<TipoDatoAcademico,Integer> {
    Optional<TipoDatoAcademicoNombre> findByTipoDatoAcademicoNombre(TipoDatoAcademicoNombre tipoDatoAcademicoNombre);
}
