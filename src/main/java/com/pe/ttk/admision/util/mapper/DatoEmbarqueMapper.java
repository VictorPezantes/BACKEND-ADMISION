package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.DatoEmbarqueDto;
import com.pe.ttk.admision.entity.admision.DatoEmbarque;
import org.mapstruct.factory.Mappers;

public interface DatoEmbarqueMapper {
    DatoEmbarqueMapper INSTANCE = Mappers.getMapper(DatoEmbarqueMapper.class);

    DatoEmbarqueDto toDatoEmbarqueDto(DatoEmbarque datoEmbarque);
}
