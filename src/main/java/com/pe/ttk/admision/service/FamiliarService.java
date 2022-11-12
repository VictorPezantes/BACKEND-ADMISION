package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.FamiliarDto;
import com.pe.ttk.admision.dto.Mensaje;
import org.springframework.data.domain.Page;

public interface FamiliarService {
    Mensaje registrar(FamiliarDto familiarDto);
    Mensaje actualizar(FamiliarDto familiarDto);
    Page<FamiliarDto> listar(Integer numPagina, Integer tamPagina, Long postulanteId);
}
