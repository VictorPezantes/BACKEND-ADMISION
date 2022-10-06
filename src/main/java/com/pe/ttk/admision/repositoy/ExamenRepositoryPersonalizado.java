package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.dto.entity.admision.ExamenEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExamenRepositoryPersonalizado {
    List<ExamenEntity> listarExamenes(Pageable pageable, String buscador, List subEstado, String fechaInformeMedico, String fechaProgramada);
}
