package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.DatoContactoEmergenciaDto;
import com.pe.ttk.admision.entity.admision.DatoContactoEmergencia;
import org.mapstruct.factory.Mappers;

public interface DatoContactoEmergenciaMapper {

    DatoContactoEmergenciaMapper INSTANCE = Mappers.getMapper(DatoContactoEmergenciaMapper.class);

    DatoContactoEmergenciaDto toDatoContactoEmergenciaDto(DatoContactoEmergencia datoContactoEmergencia);
}
