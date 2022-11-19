package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.DatoBancarioDto;
import com.pe.ttk.admision.entity.admision.DatoBancario;
import com.pe.ttk.admision.util.mapper.DatoBancarioMapper;
import org.springframework.stereotype.Component;

@Component
public class DatoBancarioMapperImpl implements DatoBancarioMapper {
    @Override
    public DatoBancarioDto toDatoBancarioDto(DatoBancario datoBancario) {
        DatoBancarioDto datoBancarioDto = new DatoBancarioDto();
        datoBancarioDto.setId(datoBancario.getId());
        datoBancarioDto.setPostulanteId(datoBancario.getPostulante().getId());
        datoBancarioDto.setMoneda(datoBancario.getMoneda());
        datoBancarioDto.setBanco(datoBancario.getBanco());
        datoBancarioDto.setCuenta(datoBancario.getCuenta());
        datoBancarioDto.setCci(datoBancario.getCci());
        datoBancarioDto.setObservacion(datoBancario.getObservacion());
        datoBancarioDto.setRuc(datoBancario.getRuc());
        datoBancarioDto.setClaveSol(datoBancario.getClaveSol());
        return datoBancarioDto;
    }
}
