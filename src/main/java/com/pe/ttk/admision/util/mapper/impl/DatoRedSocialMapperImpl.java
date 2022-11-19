package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.DatoRedSocialDto;
import com.pe.ttk.admision.entity.admision.DatoRedSocial;
import com.pe.ttk.admision.util.mapper.DatoRedSocialMapper;
import org.springframework.stereotype.Component;

@Component
public class DatoRedSocialMapperImpl implements DatoRedSocialMapper {
    @Override
    public DatoRedSocialDto toDatoRedSocialDto(DatoRedSocial datoLaboral) {
        DatoRedSocialDto datoRedSocialDto = new DatoRedSocialDto();
        datoRedSocialDto.setId(datoLaboral.getId());
        datoRedSocialDto.setNombre(datoLaboral.getNombre());
        datoRedSocialDto.setLink(datoLaboral.getLink());
        return datoRedSocialDto;
    }
}
