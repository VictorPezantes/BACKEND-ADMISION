package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.DatoBancarioDto;
import com.pe.ttk.admision.entity.admision.DatoBancario;
import org.mapstruct.factory.Mappers;

public interface DatoBancarioMapper {
    DatoBancarioMapper INSTANCE = Mappers.getMapper(DatoBancarioMapper.class);

    DatoBancarioDto toDatoBancarioDto(DatoBancario datoBancario);
}
