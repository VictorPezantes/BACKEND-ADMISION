package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.DatoContactoEmergenciaDto;
import com.pe.ttk.admision.entity.admision.DatoContactoEmergencia;
import com.pe.ttk.admision.util.mapper.DatoContactoEmergenciaMapper;
import org.springframework.stereotype.Component;

@Component
public class DatoContactoEmergenciaMapperImpl implements DatoContactoEmergenciaMapper {
    @Override
    public DatoContactoEmergenciaDto toDatoContactoEmergenciaDto(DatoContactoEmergencia datoContactoEmergencia) {
        DatoContactoEmergenciaDto datoContactoEmergenciaDto = new DatoContactoEmergenciaDto();
        datoContactoEmergenciaDto.setId(datoContactoEmergencia.getId());
        datoContactoEmergenciaDto.setPostulanteId(datoContactoEmergencia.getPostulante().getId());
        datoContactoEmergenciaDto.setParentescoId(datoContactoEmergencia.getParentesco().getId());
        datoContactoEmergenciaDto.setPrimerNombre(datoContactoEmergencia.getPrimerNombre());
        datoContactoEmergenciaDto.setSegundoNombre(datoContactoEmergencia.getSegundoNombre());
        datoContactoEmergenciaDto.setPrimerApellido(datoContactoEmergencia.getPrimerApellido());
        datoContactoEmergenciaDto.setSegundoApellido(datoContactoEmergenciaDto.getSegundoApellido());
        datoContactoEmergenciaDto.setCelular(datoContactoEmergencia.getCelular());
        datoContactoEmergenciaDto.setTelefono(datoContactoEmergencia.getTelefono());
        datoContactoEmergenciaDto.setEmail(datoContactoEmergencia.getEmail());
        return datoContactoEmergenciaDto;
    }
}
