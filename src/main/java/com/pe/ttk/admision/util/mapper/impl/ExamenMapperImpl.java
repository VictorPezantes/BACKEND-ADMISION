package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.entity.admision.ExamenEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.CentroMedicoNombre;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import com.pe.ttk.admision.util.mapper.ExamenMapper;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
public class ExamenMapperImpl  implements ExamenMapper {
    @Override
    public ExamenDto toExamenDto(ExamenEntity examenEntity) {
        ExamenDto examenDto = new ExamenDto();
        examenDto.setUrlResultadoExamen(examenEntity.getResultadoExamen());
        examenDto.setId(examenEntity.getId());
        examenDto.setFecha(examenEntity.getFecha());
        examenDto.setTipoExamenId(examenDto.getTipoExamenId());
        examenDto.setObservacion(examenDto.getObservacion());
        examenDto.setFechaProgramada(examenEntity.getFechaProgramada());
        examenDto.setCentroMedicoId(examenEntity.getCentroMedico().getId());
        examenDto.setFechaResultado(examenEntity.getFechaResultado());
        examenDto.setPostulanteId(examenEntity.getPostulante().getId());
        examenDto.setSubEstadoId(examenEntity.getSubEstado().getId());
        examenDto.setFechaInformeMedico(examenEntity.getFechaInformeMedico());
        return examenDto;
    }

    @Override
    public ExamenEntity toExamenEntity(ExamenDto examenDto) {
        ExamenEntity examenEntity = new ExamenEntity();
        examenEntity.setResultadoExamen(examenDto.getUrlResultadoExamen());
        examenEntity.setId(examenDto.getId());
        examenEntity.setFecha(examenDto.getFecha());
        examenEntity.setFechaResultado(examenDto.getFechaResultado());
        examenEntity.setFechaProgramada(examenDto.getFechaProgramada());
        examenEntity.setFechaInformeMedico(examenDto.getFechaInformeMedico());
        examenEntity.setObservacion(examenDto.getObservacion());
        return examenEntity;
    }
}
