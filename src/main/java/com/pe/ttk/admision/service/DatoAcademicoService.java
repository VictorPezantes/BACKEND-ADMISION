package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.dto.Mensaje;
import org.springframework.data.domain.Page;

public interface DatoAcademicoService {
    Mensaje registrar(DatoAcademicoDto datoAcademicoDto);
    Mensaje actualizar(DatoAcademicoDto datoAcademicoDto);
    Page<DatoAcademicoDto> listar(Integer numPagina, Integer tamPagina, Long postulanteId);
}
