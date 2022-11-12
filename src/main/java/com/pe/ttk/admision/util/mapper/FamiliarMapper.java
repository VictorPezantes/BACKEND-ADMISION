package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.FamiliarDto;
import com.pe.ttk.admision.entity.admision.Familiar;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface FamiliarMapper {
    FamiliarMapper INSTANCE = Mappers.getMapper(FamiliarMapper.class);

    FamiliarDto toFamiliarDto(Familiar familiar);
}
