package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.ExamenEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.repositoy.*;
import com.pe.ttk.admision.service.ExamenService;
import com.pe.ttk.admision.util.mapper.ExamenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    CentroMedicoRepository centroMedicoRepository;

    @Autowired
    TipoExamenRepository tipoExamenRepository;

    @Autowired
    PostulanteRepository postulanteRepository;

    @Autowired
    SubEstadoRepository subEstadoRepository;

    @Autowired
    ExamenRepository examenRepository;

    @Autowired
    ExamenMapper examenMapper;
    @Override
    public Mensaje registrarExamen(ExamenDto examenDto) {
        Optional<CentroMedico> centroMedicoDb = centroMedicoRepository.findById(examenDto.getCentroMedicoId());
        if (centroMedicoDb.isEmpty()){
            return new Mensaje("centro médico no existe",false);
        }

        Optional<TipoExamen> tipoExamenDb = tipoExamenRepository.findById(examenDto.getTipoExamenId());
        if (tipoExamenDb.isEmpty()){
            return new Mensaje("tipo de examen no existe",false);
        }
        if(examenDto.getPostulanteId() == null){
            return new Mensaje("se necesita postulanteId",false);
        }
        if(examenDto.getPostulanteId() == 0){
            return new Mensaje("el id no puede ser 0",false);
        }
        Optional<PostulanteEntity> postulanteEntityDb = postulanteRepository.findById(examenDto.getPostulanteId());
        if (postulanteEntityDb.isEmpty()){
            return new Mensaje("postulante no existe",false);
        }

        Optional<SubEstado> subEstadoDb = subEstadoRepository.findById(examenDto.getSubEstadoId());
        if (subEstadoDb.isEmpty()){
            return new Mensaje("Sub estado no existe",false);
        }
        ExamenEntity examenEntity = examenMapper.toExamenEntity(examenDto);
        examenEntity.setCentroMedico(centroMedicoDb.get());
        examenEntity.setTipoExamen(tipoExamenDb.get());
        examenEntity.setPostulante(postulanteEntityDb.get());
        examenEntity.setSubEstado(subEstadoDb.get());
        try{

            examenRepository.save(examenEntity);
        }catch(Exception ex){
            System.out.println(ex);
        }

        return new Mensaje("Se registró el examen",true);
    }

    @Override
    public Page<ExamenDto> listarExamenes(Integer numPagina, Integer tamPagina, String buscador, List subEstado, String fechaInformeMedico, String fechaProgramada) {
        return null;
    }

    @Override
    public Mensaje actualizarEstadoExamen(ExamenDto examenDto) {
        return null;
    }
}
