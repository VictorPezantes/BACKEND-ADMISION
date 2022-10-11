package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.dto.Mensaje;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExamenService {
    Mensaje registrarExamen(ExamenDto examenDto);
    Page<ExamenDto> listarExamenes(Integer numPagina, Integer tamPagina, String buscador, List subEstado, String fechaInformeMedico, String fechaProgramada);
    Mensaje actualizarEstadoExamen(ExamenDto examenDto);
}
