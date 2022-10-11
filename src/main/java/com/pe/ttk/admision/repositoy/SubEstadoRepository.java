package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;
@Repository
public interface SubEstadoRepository extends JpaRepository<SubEstado, Integer> {
    Optional<SubEstadoNombre> findBySubEstadoNombre(@NotNull SubEstadoNombre subEstadoNombre);
}
