package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.entity.admision.ExamenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ExamenMapper {

    ExamenMapper INSTANCE = Mappers.getMapper(ExamenMapper.class);

    ExamenDto toExamenDto(ExamenEntity examenEntity);
    ExamenEntity toExamenEntity(ExamenDto examenDto);
}
