package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.FamiliarDto;
import com.pe.ttk.admision.entity.admision.Familiar;
import com.pe.ttk.admision.util.mapper.FamiliarMapper;
import org.springframework.stereotype.Component;

@Component
public class FamiliarMapperImpl implements FamiliarMapper {
    @Override
    public FamiliarDto toFamiliarDto(Familiar familiar) {
        FamiliarDto familiarDto = new FamiliarDto();
        familiarDto.setPrimerApellido(familiar.getPrimerApellido());
        familiarDto.setSegundoApellido(familiar.getSegundoApellido());
        familiarDto.setPrimerNombre(familiar.getPrimerNombre());
        familiarDto.setSegundoNombre(familiar.getSegundoNombre());
        familiarDto.setDni(familiar.getDni());
        familiarDto.setFechaNacimiento(familiar.getFechaNacimiento());
        familiarDto.setOcupacion(familiar.getOcupacion());
        familiarDto.setDireccion(familiar.getDireccion());
        if(familiar.getDistrito()!= null){
            familiarDto.setDistritoId(familiar.getDistrito().getId());
            familiarDto.setDistritoNombre(familiar.getDistrito().getNombre());
        }
        if(familiar.getProvincia()!= null){
            familiarDto.setProvinciaId(familiar.getProvincia().getId());
            familiarDto.setProvinciaNombre(familiar.getProvincia().getNombre());
        }
        if(familiar.getDepartamento()!= null){
            familiarDto.setDepartamentoId(familiar.getDepartamento().getId());
            familiarDto.setDepartamentoNombre(familiar.getDepartamento().getNombre());
        }
        if(familiar.getPostulante()!= null){
            familiarDto.setPostulanteId(familiar.getPostulante().getId());
            familiarDto.setPostulanteNombre(familiar.getPostulante().getPrimerNombre()+" "+familiar.getPostulante().getApellidoPaterno());
        }
        return familiarDto;
    }
}
