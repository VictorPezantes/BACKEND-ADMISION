package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.entity.admision.DatoAcademico;
import com.pe.ttk.admision.util.mapper.DatoAcademicoMapper;
import org.springframework.stereotype.Component;

@Component
public class DatoAcademicoMapperImpl implements DatoAcademicoMapper {
    @Override
    public DatoAcademicoDto toDatoAcademicoDto(DatoAcademico datoAcademico) {
        DatoAcademicoDto datoAcademicoDto = new DatoAcademicoDto();
        datoAcademicoDto.setId(datoAcademico.getId());
        datoAcademicoDto.setPostulanteId(datoAcademico.getPostulante().getId());
        datoAcademicoDto.setTipoDatoAcademicoId(datoAcademico.getTipoDatoAcademico().getId());
        datoAcademicoDto.setTipoDatoAcademicoNombre(datoAcademico.getTipoDatoAcademico().getTipoDatoAcademicoNombre().toString());
        datoAcademicoDto.setNivelEstudioId(datoAcademico.getNivelEstudio().getId());
        datoAcademicoDto.setNivelEstudioNombre(datoAcademico.getNivelEstudio().getNivelEstudioNombre().toString());
        datoAcademicoDto.setCentroEducativo(datoAcademico.getCentroEducativo());
        datoAcademicoDto.setFechaInicio(datoAcademico.getFechaInicio());
        datoAcademicoDto.setFechaTermino(datoAcademico.getFechaTermino());
        datoAcademicoDto.setDireccion(datoAcademico.getDireccion());
        datoAcademicoDto.setDistritoId(datoAcademico.getDistrito().getId());
        datoAcademicoDto.setDistritoNombre(datoAcademico.getDistrito().getNombre());
        datoAcademicoDto.setProvinciaId(datoAcademico.getProvincia().getId());
        datoAcademicoDto.setProvinciaNombre(datoAcademico.getProvincia().getNombre());
        datoAcademicoDto.setDepartamentoId(datoAcademico.getDepartamento().getId());
        datoAcademicoDto.setDepartamentoNombre(datoAcademico.getDepartamento().getNombre());

        return datoAcademicoDto;
    }
}
