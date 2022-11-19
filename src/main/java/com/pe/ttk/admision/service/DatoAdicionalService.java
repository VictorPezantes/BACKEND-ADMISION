package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.*;
import com.pe.ttk.admision.entity.admision.*;
import org.springframework.data.domain.Page;

public interface DatoAdicionalService {
    Mensaje registrarDatoAcademico(DatoAcademicoDto datoAcademicoDto);
    Mensaje actualizarDatoAcademico(DatoAcademicoDto datoAcademicoDto);
    Page<DatoAcademicoDto> listarDatoAcademico(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoBancario(DatoBancarioDto datoBancario);
    Mensaje actualizarDatoBancario(DatoBancarioDto datoBancario);
    Page<DatoBancarioDto> listarDatoBancario(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoContactoEmergencia(DatoContactoEmergenciaDto datoContactoEmergencia);
    Mensaje actualizarDatoContactoEmergencia(DatoContactoEmergenciaDto datoContactoEmergencia);
    Page<DatoContactoEmergenciaDto> listarDatoContactoEmergencia(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoEmbarque(DatoEmbarqueDto datoEmbarque);
    Mensaje actualizarDatoEmbarque(DatoEmbarqueDto datoEmbarque);
    Page<DatoEmbarqueDto> listarDatoEmbarque(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoLaboral(DatoLaboralDto datoLaboral);
    Mensaje actualizarDatoLaboral(DatoLaboralDto datoLaboral);
    Page<DatoLaboralDto> listarDatoLaboral(Integer numPagina, Integer tamPagina, Long postulanteId);
    Mensaje registrarDatoRedSocial(DatoRedSocialDto datoRedSocial);
    Mensaje actualizarDatoRedSocial(DatoRedSocialDto datoRedSocial);
    Page<DatoRedSocialDto> listarDatoRedSocial(Integer numPagina, Integer tamPagina, Long postulanteId);
}
