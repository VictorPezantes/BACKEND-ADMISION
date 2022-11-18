package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.dto.FamiliarDto;
import com.pe.ttk.admision.entity.admision.DatoAcademico;
import com.pe.ttk.admision.entity.admision.Familiar;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DatoAcademicoMapper {
    DatoAcademicoMapper INSTANCE = Mappers.getMapper(DatoAcademicoMapper.class);

    DatoAcademicoDto toDatoAcademicoDto(DatoAcademico datoAcademico);
}
