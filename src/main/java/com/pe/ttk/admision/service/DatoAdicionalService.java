package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.dto.DatoBancarioDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.*;
import org.springframework.data.domain.Page;

public interface DatoAdicionalService {
    Mensaje registrarDatoAcademico(DatoAcademicoDto datoAcademicoDto);
    Mensaje actualizarDatoAcademico(DatoAcademicoDto datoAcademicoDto);
    Page<DatoAcademicoDto> listarDatoAcademico(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoBancario(DatoBancarioDto datoBancario);
    Mensaje actualizarDatoBancario(DatoBancarioDto datoBancario);
    Page<DatoBancarioDto> listarDatoBancario(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoBancario(DatoContactoEmergencia datoContactoEmergencia);
    Mensaje actualizarDatoBancario(DatoContactoEmergencia datoContactoEmergencia);
    Page<DatoContactoEmergencia> listarDatoContactoEmergencia(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoEmbarque(DatoEmbarque datoEmbarque);
    Mensaje actualizarDatoEmbarque(DatoEmbarque datoEmbarque);
    Page<DatoEmbarque> listarDatoEmbarque(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoLaboral(DatoLaboral datoLaboral);
    Mensaje actualizarDatoLaboral(DatoLaboral datoLaboral);
    Page<DatoLaboral> listarDatoLaboral(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoRedSocial(DatoRedSocial datoRedSocial);
    Mensaje actualizarDatoRedSocial(DatoRedSocial datoRedSocial);
    Page<DatoRedSocial> listarDatoRedSocial(Integer numPagina, Integer tamPagina, Long postulanteId);
}
