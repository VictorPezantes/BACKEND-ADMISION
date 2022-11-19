package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.DatoEmbarqueDto;
import com.pe.ttk.admision.entity.admision.DatoEmbarque;
import com.pe.ttk.admision.util.mapper.DatoEmbarqueMapper;
import org.springframework.stereotype.Component;

@Component
public class DatoEmbarqueMapperImpl implements DatoEmbarqueMapper {

    @Override
    public DatoEmbarqueDto toDatoEmbarqueDto(DatoEmbarque datoEmbarque) {
        DatoEmbarqueDto datoEmbarqueDto = new DatoEmbarqueDto();
        datoEmbarqueDto.setId(datoEmbarque.getId());
        datoEmbarqueDto.setPostulanteId(datoEmbarque.getPostulante().getId());
        datoEmbarqueDto.setNumeroEmbarque(datoEmbarque.getNumeroEmbarque());
        datoEmbarqueDto.setBuqueEmbarque(datoEmbarque.getBuqueEmbarque());
        datoEmbarqueDto.setTecnicoACargo(datoEmbarque.getTecnicoACargo());
        datoEmbarqueDto.setTrabajoARealizar(datoEmbarque.getTrabajoARealizar());
        datoEmbarqueDto.setFechaEmbarque(datoEmbarque.getFechaEmbarque());
        datoEmbarqueDto.setFechaDesembarque(datoEmbarque.getFechaDesembarque());
        return datoEmbarqueDto;
    }
}
