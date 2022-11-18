package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.dto.FamiliarDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.DatoAcademico;
import com.pe.ttk.admision.entity.admision.Familiar;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.*;
import com.pe.ttk.admision.repository.*;
import com.pe.ttk.admision.service.DatoAcademicoService;
import com.pe.ttk.admision.util.mapper.DatoAcademicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatoAcademicoServiceImpl implements DatoAcademicoService {

    @Autowired
    DatoAcademicoRepository datoAcademicoRepository;

    @Autowired
    DistritoRepository distritoRepository;

    @Autowired
    ProvinciaRepository provinciaRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    PostulanteRepository postulanteRepository;

    @Autowired
    TipoDatoAcademicoRepository tipoDatoAcademicoRepository;

    @Autowired
    NivelEstudioRepository nivelEstudioRepository;

    @Autowired
    DatoAcademicoMapper datoAcademicoMapper;

    @Override
    public Mensaje registrar(DatoAcademicoDto datoAcademicoDto) {
        DatoAcademico datoAcademico = new DatoAcademico();

        Optional<Distrito> distrito = distritoRepository.findById(datoAcademicoDto.getDistritoId());
        if (distrito.isEmpty()){
            return new Mensaje("No existe distrito",false);
        }
        datoAcademico.setDistrito(distrito.get());

        Optional<Provincia> provincia = provinciaRepository.findById(datoAcademicoDto.getProvinciaId());
        if (provincia.isEmpty()){
            return new Mensaje("No existe provincia",false);
        }
        datoAcademico.setProvincia(provincia.get());

        Optional<Departamento> departamento = departamentoRepository.findById(datoAcademicoDto.getDepartamentoId());
        if (departamento.isEmpty()){
            return new Mensaje("No existe departamento",false);
        }
        datoAcademico.setDepartamento(departamento.get());

        Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(datoAcademicoDto.getPostulanteId());
        if (postulanteEntity.isEmpty()){
            return new Mensaje("No existe postulante",false);
        }
        datoAcademico.setPostulante(postulanteEntity.get());

        Optional<NivelEstudio> nivelEstudio = nivelEstudioRepository.findById(datoAcademicoDto.getNivelEstudioId());
        if (nivelEstudio.isEmpty()){
            return new Mensaje("No existe nivel de estudio",false);
        }
        datoAcademico.setNivelEstudio(nivelEstudio.get());

        Optional<TipoDatoAcademico> tipoDatoAcademico = tipoDatoAcademicoRepository.findById(datoAcademicoDto.getTipoDatoAcademicoId());
        if (tipoDatoAcademico.isEmpty()){
            return new Mensaje("No existe tipo de dato academico",false);
        }
        datoAcademico.setTipoDatoAcademico(tipoDatoAcademico.get());

        datoAcademico.setCentroEducativo(datoAcademicoDto.getCentroEducativo());
        datoAcademico.setFechaInicio(datoAcademicoDto.getFechaInicio());
        datoAcademico.setFechaTermino(datoAcademicoDto.getFechaTermino());
        datoAcademico.setDireccion(datoAcademico.getDireccion());

        datoAcademicoRepository.save(datoAcademico);
        return new Mensaje("Se registró con éxito",true);
    }

    @Override
    public Mensaje actualizar(DatoAcademicoDto datoAcademicoDto) {
        if(datoAcademicoDto.getId() ==null){
            return new Mensaje("Id de dato academico no es válido",false);
        }
        Optional<DatoAcademico> datoAcademicoDb = datoAcademicoRepository.findById(datoAcademicoDto.getId());
        if (datoAcademicoDb.isEmpty()){
            return new Mensaje("No se encontró dato académico",false);
        }
        if (datoAcademicoDto.getPostulanteId()!= null){
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(datoAcademicoDto.getPostulanteId());
            if (postulanteEntity.isEmpty()){
                return new Mensaje("No existe postulante",false);
            }
            datoAcademicoDb.get().setPostulante(postulanteEntity.get());
        }
        if(datoAcademicoDto.getTipoDatoAcademicoId()!=null){
            Optional<TipoDatoAcademico> tipoDatoAcademico = tipoDatoAcademicoRepository.findById(datoAcademicoDto.getTipoDatoAcademicoId());
            if (tipoDatoAcademico.isEmpty()){
                return new Mensaje("No existe tipo de dato academico",false);
            }
            datoAcademicoDb.get().setTipoDatoAcademico(tipoDatoAcademico.get());
        }
        if(datoAcademicoDto.getNivelEstudioId()!= null){
            Optional<NivelEstudio> nivelEstudio = nivelEstudioRepository.findById(datoAcademicoDto.getNivelEstudioId());
            if (nivelEstudio.isEmpty()){
                return new Mensaje("No existe nivel de estudio",false);
            }
            datoAcademicoDb.get().setNivelEstudio(nivelEstudio.get());
        }
        if(datoAcademicoDto.getCentroEducativo() != null){
            datoAcademicoDb.get().setCentroEducativo(datoAcademicoDto.getCentroEducativo());
        }
        if(datoAcademicoDto.getFechaInicio() != null){
            datoAcademicoDb.get().setFechaInicio(datoAcademicoDto.getFechaInicio());
        }
        if(datoAcademicoDto.getFechaTermino() != null){
            datoAcademicoDb.get().setFechaTermino(datoAcademicoDto.getFechaTermino());
        }
        if(datoAcademicoDto.getDireccion() != null){
            datoAcademicoDb.get().setDireccion(datoAcademicoDto.getDireccion());
        }
        if(datoAcademicoDto.getDistritoId()!= null){
            Optional<Distrito> distrito = distritoRepository.findById(datoAcademicoDto.getDistritoId());
            if (distrito.isEmpty()){
                return new Mensaje("No existe distrito",false);
            }
            datoAcademicoDb.get().setDistrito(distrito.get());
        }
        if(datoAcademicoDto.getProvinciaId()!= null){
            Optional<Provincia> provincia = provinciaRepository.findById(datoAcademicoDto.getProvinciaId());
            if (provincia.isEmpty()){
                return new Mensaje("No existe provincia",false);
            }
            datoAcademicoDb.get().setProvincia(provincia.get());
        }
        if(datoAcademicoDto.getDepartamentoId()!= null){
            Optional<Departamento> departamento = departamentoRepository.findById(datoAcademicoDto.getDepartamentoId());
            if (departamento.isEmpty()){
                return new Mensaje("No existe departamento",false);
            }
            datoAcademicoDb.get().setDepartamento(departamento.get());
        }

        return new Mensaje("Se actualizó con éxito",true);
    }

    @Override
    public Page<DatoAcademicoDto> listar(Integer numPagina, Integer tamPagina, Long postulanteId) {
        Pageable pageable = PageRequest.of(numPagina, tamPagina);
        List<DatoAcademico> lista = datoAcademicoRepository.listar(postulanteId, pageable);
        List<DatoAcademicoDto> listaDatoAcademico = lista.stream().map(datoAcademicoMapper.INSTANCE::toDatoAcademicoDto).collect(Collectors.toList());
        if(!lista.isEmpty()){
            return new PageImpl<>(listaDatoAcademico, pageable, lista.size());
        }
        return null;
    }
}
