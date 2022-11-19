package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.DatoLaboralDto;
import com.pe.ttk.admision.entity.admision.DatoLaboral;
import com.pe.ttk.admision.util.mapper.DatoLaboralMapper;
import org.springframework.stereotype.Component;

@Component
public class DatoLaboralMapperImpl implements DatoLaboralMapper {

    @Override
    public DatoLaboralDto toDatoLaboralDto(DatoLaboral datoLaboral) {

        DatoLaboralDto datoLaboralDto = new DatoLaboralDto();
        datoLaboralDto.setId(datoLaboral.getId());
        datoLaboralDto.setPostulanteId(datoLaboral.getPostulante().getId());
        datoLaboralDto.setTrabajo(datoLaboral.getTrabajo());
        datoLaboralDto.setPuesto(datoLaboral.getPuesto());
        datoLaboralDto.setEmpresa(datoLaboral.getEmpresa());
        datoLaboralDto.setFechaInicio(datoLaboral.getFechaInicio());
        datoLaboralDto.setFechaTermino(datoLaboral.getFechaTermino());
        datoLaboralDto.setDireccion(datoLaboral.getDireccion());
        datoLaboralDto.setDistritoId(datoLaboral.getDistrito().getId());
        datoLaboralDto.setDistritoNombre(datoLaboral.getDistrito().getNombre());
        datoLaboralDto.setProvinciaId(datoLaboral.getProvincia().getId());
        datoLaboralDto.setProvinciaNombre(datoLaboral.getProvincia().getNombre());
        datoLaboralDto.setDepartamentoId(datoLaboral.getDepartamento().getId());
        datoLaboralDto.setDepartamentoNombre(datoLaboral.getDepartamento().getNombre());
        datoLaboralDto.setFunciones(datoLaboral.getFunciones());
        return datoLaboralDto;
    }
}
