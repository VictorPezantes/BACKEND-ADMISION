package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.dto.entity.master.SubEstado;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface SubEstadoRepository extends JpaRepository<SubEstado, Integer> {
    Optional<SubEstado> findBySubEstadoNombre(@NotNull SubEstadoNombre subEstadoNombre);
}
