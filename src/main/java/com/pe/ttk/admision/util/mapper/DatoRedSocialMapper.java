package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.DatoRedSocialDto;
import com.pe.ttk.admision.entity.admision.DatoRedSocial;
import org.mapstruct.factory.Mappers;

public interface DatoRedSocialMapper {
    DatoRedSocialMapper INSTANCE = Mappers.getMapper(DatoRedSocialMapper.class);

    DatoRedSocialDto toDatoRedSocialDto(DatoRedSocial datoLaboral);
}
