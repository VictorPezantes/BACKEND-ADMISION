package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.DatoLaboralDto;
import com.pe.ttk.admision.entity.admision.DatoLaboral;
import org.mapstruct.factory.Mappers;

public interface DatoLaboralMapper {
    DatoLaboralMapper INSTANCE = Mappers.getMapper(DatoLaboralMapper.class);

    DatoLaboralDto toDatoLaboralDto(DatoLaboral datoLaboral);
}
