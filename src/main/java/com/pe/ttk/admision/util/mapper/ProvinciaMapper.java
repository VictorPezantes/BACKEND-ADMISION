package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.ProvinciaDto;
import com.pe.ttk.admision.entity.master.Provincia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProvinciaMapper {

    ProvinciaMapper INSTANCE = Mappers.getMapper(ProvinciaMapper.class);

    ProvinciaDto toProvincia(Provincia provincia);

}
