package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.master.Parentesco;
import com.pe.ttk.admision.enums.ParentescoNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentescoRepository extends JpaRepository<Parentesco, Integer> {

    Optional<ParentescoNombre> findAllByParentescoNombre(ParentescoNombre parentescoNombre);

}
