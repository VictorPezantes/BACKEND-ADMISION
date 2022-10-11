package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.entity.admision.ExamenEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExamenRepositoryPersonalizado {
    List<ExamenEntity> listarExamenes(Pageable pageable, String buscador, List subEstado, String fechaInformeMedico, String fechaProgramada);
}
