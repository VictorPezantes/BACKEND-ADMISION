package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.dto.DatoBancarioDto;
import com.pe.ttk.admision.dto.DatoContactoEmergenciaDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.*;
import com.pe.ttk.admision.entity.master.*;
import com.pe.ttk.admision.repository.*;
import com.pe.ttk.admision.service.DatoAdicionalService;
import com.pe.ttk.admision.util.mapper.DatoAcademicoMapper;
import com.pe.ttk.admision.util.mapper.DatoBancarioMapper;
import com.pe.ttk.admision.util.mapper.DatoContactoEmergenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatoAdicionalServiceImpl implements DatoAdicionalService {

    @Autowired
    DatoAcademicoRepository datoAcademicoRepository;

    @Autowired
    DatoBancarioRepository datoBancarioRepository;

    @Autowired
    DatoContactoEmergenciaRepository datoContactoEmergenciaRepository;

    @Autowired
    DatoEmbarqueRepository datoEmbarqueRepository;

    @Autowired
    DatoLaboralRepository datoLaboralRepository;

    @Autowired
    DatoRedSocialRepository datoRedSocialRepository;

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
    ParentescoRepository parentescoRepository;

    @Autowired
    DatoAcademicoMapper datoAcademicoMapper;

    @Autowired
    DatoBancarioMapper datoBancarioMapper;

    @Autowired
    DatoContactoEmergenciaMapper datoContactoEmergenciaMapper;

    @Override
    public Mensaje registrarDatoAcademico(DatoAcademicoDto datoAcademicoDto) {
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
    public Mensaje actualizarDatoAcademico(DatoAcademicoDto datoAcademicoDto) {
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
    public Page<DatoAcademicoDto> listarDatoAcademico(Integer numPagina, Integer tamPagina, Long postulanteId) {
        Pageable pageable = PageRequest.of(numPagina, tamPagina);
        List<DatoAcademico> lista = datoAcademicoRepository.listar(postulanteId, pageable);
        List<DatoAcademicoDto> listaDatoAcademico = lista.stream().map(datoAcademicoMapper.INSTANCE::toDatoAcademicoDto).collect(Collectors.toList());
        if(!lista.isEmpty()){
            return new PageImpl<>(listaDatoAcademico, pageable, lista.size());
        }
        return null;
    }

    @Override
    public Mensaje registrarDatoBancario(DatoBancarioDto datoBancarioDto) {
        DatoBancario datoBancario = new DatoBancario();
        Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(datoBancarioDto.getPostulanteId());
        if (postulanteEntity.isEmpty()){
            return new Mensaje("No existe postulante",false);
        }
        datoBancario.setPostulante(postulanteEntity.get());
        datoBancario.setMoneda(datoBancarioDto.getMoneda());
        datoBancario.setBanco(datoBancarioDto.getBanco());
        datoBancario.setCuenta(datoBancarioDto.getCuenta());
        datoBancario.setCci(datoBancarioDto.getCci());
        datoBancario.setObservacion(datoBancarioDto.getObservacion());
        datoBancario.setRuc(datoBancarioDto.getRuc());
        datoBancario.setClaveSol(datoBancarioDto.getClaveSol());
        datoBancarioRepository.save(datoBancario);
        return new Mensaje("Se registró con éxito",true);
    }

    @Override
    public Mensaje actualizarDatoBancario(DatoBancarioDto datoBancarioDto) {
        if(datoBancarioDto.getId() ==null){
            return new Mensaje("Id de dato academico no es válido",false);
        }
        Optional<DatoBancario> datoBancarioDb = datoBancarioRepository.findById(datoBancarioDto.getId());
        if (datoBancarioDb.isEmpty()){
            return new Mensaje("No se encontró dato académico",false);
        }
        if (datoBancarioDto.getPostulanteId()!= null){
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(datoBancarioDto.getPostulanteId());
            if (postulanteEntity.isEmpty()){
                return new Mensaje("No existe postulante",false);
            }
            datoBancarioDb.get().setPostulante(postulanteEntity.get());
        }
        if(datoBancarioDto.getMoneda() != null) {
            datoBancarioDb.get().setMoneda(datoBancarioDto.getMoneda());
        }
        if(datoBancarioDto.getBanco() != null) {
            datoBancarioDb.get().setBanco(datoBancarioDto.getBanco());
        }
        if(datoBancarioDto.getCuenta() != null) {
            datoBancarioDb.get().setCuenta(datoBancarioDto.getCuenta());
        }
        if(datoBancarioDto.getCci() != null) {
            datoBancarioDb.get().setCci(datoBancarioDto.getCci());
        }
        if(datoBancarioDto.getObservacion() != null) {
            datoBancarioDb.get().setObservacion(datoBancarioDto.getObservacion());
        }
        if(datoBancarioDto.getRuc() != null) {
            datoBancarioDb.get().setRuc(datoBancarioDto.getRuc());
        }
        if(datoBancarioDto.getClaveSol() != null) {
            datoBancarioDb.get().setClaveSol(datoBancarioDto.getClaveSol());
        }
        return new Mensaje("Se actualizó con éxito",true);
    }

    @Override
    public Page<DatoBancarioDto> listarDatoBancario(Integer numPagina, Integer tamPagina, Long postulanteId) {
        Pageable pageable = PageRequest.of(numPagina, tamPagina);
        List<DatoBancario> lista = datoBancarioRepository.listar(postulanteId, pageable);
        List<DatoBancarioDto> listaDatoBancario = lista.stream().map(datoBancarioMapper.INSTANCE::toDatoBancarioDto).collect(Collectors.toList());
        if(!lista.isEmpty()){
            return new PageImpl<>(listaDatoBancario, pageable, lista.size());
        }
        return null;
    }

    @Override
    public Mensaje registrarDatoContactoEmergencia(DatoContactoEmergenciaDto datoContactoEmergenciaDto) {
        DatoContactoEmergencia datoContactoEmergencia = new DatoContactoEmergencia();
        Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(datoContactoEmergenciaDto.getPostulanteId());
        if (postulanteEntity.isEmpty()){
            return new Mensaje("No existe postulante",false);
        }
        datoContactoEmergencia.setPostulante(postulanteEntity.get());
        Optional<Parentesco> parentescoOptional = parentescoRepository.findById(datoContactoEmergenciaDto.getParentescoId());
        if (parentescoOptional.isEmpty()){
            return new Mensaje("No existe postulante",false);
        }
        datoContactoEmergencia.setParentesco(parentescoOptional.get());

        datoContactoEmergencia.setPrimerNombre(datoContactoEmergenciaDto.getPrimerNombre());
        datoContactoEmergencia.setSegundoNombre(datoContactoEmergenciaDto.getSegundoNombre());
        datoContactoEmergencia.setPrimerApellido(datoContactoEmergenciaDto.getPrimerApellido());
        datoContactoEmergencia.setSegundoApellido(datoContactoEmergenciaDto.getSegundoApellido());
        datoContactoEmergencia.setCelular(datoContactoEmergenciaDto.getCelular());
        datoContactoEmergencia.setTelefono(datoContactoEmergenciaDto.getTelefono());
        datoContactoEmergencia.setEmail(datoContactoEmergenciaDto.getEmail());

        return new Mensaje("Se registró con éxito",true);
    }

    @Override
    public Mensaje actualizarDatoContactoEmergencia(DatoContactoEmergenciaDto datoContactoEmergenciaDto) {
        if(datoContactoEmergenciaDto.getId() ==null){
            return new Mensaje("Id de dato academico no es válido",false);
        }
        Optional<DatoContactoEmergencia> datoContactoEmergenciaOptional = datoContactoEmergenciaRepository.findById(datoContactoEmergenciaDto.getId());
        if (datoContactoEmergenciaOptional.isEmpty()){
            return new Mensaje("No se encontró dato académico",false);
        }
        if(datoContactoEmergenciaDto.getPostulanteId()!= null){
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(datoContactoEmergenciaDto.getPostulanteId());
            if (postulanteEntity.isEmpty()){
                return new Mensaje("No existe postulante",false);
            }
            datoContactoEmergenciaOptional.get().setPostulante(postulanteEntity.get());
        }
        if(datoContactoEmergenciaDto.getParentescoId()!=null){
            Optional<Parentesco> parentescoOptional = parentescoRepository.findById(datoContactoEmergenciaDto.getParentescoId());
            if (parentescoOptional.isEmpty()){
                return new Mensaje("No existe postulante",false);
            }
            datoContactoEmergenciaOptional.get().setParentesco(parentescoOptional.get());
        }
        if(datoContactoEmergenciaDto.getPrimerNombre() != null){
            datoContactoEmergenciaOptional.get().setPrimerNombre(datoContactoEmergenciaDto.getPrimerNombre());
        }
        if(datoContactoEmergenciaDto.getSegundoNombre() != null){
            datoContactoEmergenciaOptional.get().setSegundoNombre(datoContactoEmergenciaDto.getSegundoNombre());
        }
        if(datoContactoEmergenciaDto.getPrimerApellido() != null){
            datoContactoEmergenciaOptional.get().setPrimerApellido(datoContactoEmergenciaDto.getPrimerApellido());
        }
        if(datoContactoEmergenciaDto.getSegundoApellido() != null){
            datoContactoEmergenciaOptional.get().setSegundoApellido(datoContactoEmergenciaDto.getSegundoApellido());
        }
        if(datoContactoEmergenciaDto.getCelular() != null){
            datoContactoEmergenciaOptional.get().setCelular(datoContactoEmergenciaDto.getCelular());
        }
        if(datoContactoEmergenciaDto.getTelefono() != null){
            datoContactoEmergenciaOptional.get().setTelefono(datoContactoEmergenciaDto.getTelefono());
        }
        if(datoContactoEmergenciaDto.getEmail() != null){
            datoContactoEmergenciaOptional.get().setEmail(datoContactoEmergenciaDto.getEmail());
        }

        return new Mensaje("Se actualizó con éxito",true);
    }

    @Override
    public Page<DatoContactoEmergenciaDto> listarDatoContactoEmergencia(Integer numPagina, Integer tamPagina, Long postulanteId) {
        Pageable pageable = PageRequest.of(numPagina, tamPagina);
        List<DatoContactoEmergencia> lista = datoContactoEmergenciaRepository.listar(postulanteId, pageable);
        List<DatoContactoEmergenciaDto> listaDatoBancario = lista.stream().map(datoContactoEmergenciaMapper.INSTANCE::toDatoContactoEmergenciaDto).collect(Collectors.toList());
        if(!lista.isEmpty()){
            return new PageImpl<>(listaDatoBancario, pageable, lista.size());
        }
        return null;
    }

    @Override
    public Mensaje registrarDatoEmbarque(DatoEmbarque datoEmbarque) {
        return null;
    }

    @Override
    public Mensaje actualizarDatoEmbarque(DatoEmbarque datoEmbarque) {
        return null;
    }

    @Override
    public Page<DatoEmbarque> listarDatoEmbarque(Integer numPagina, Integer tamPagina, Long postulanteId) {
        return null;
    }

    @Override
    public Mensaje registrarDatoLaboral(DatoLaboral datoLaboral) {
        return null;
    }

    @Override
    public Mensaje actualizarDatoLaboral(DatoLaboral datoLaboral) {
        return null;
    }

    @Override
    public Page<DatoLaboral> listarDatoLaboral(Integer numPagina, Integer tamPagina, Long postulanteId) {
        return null;
    }

    @Override
    public Mensaje registrarDatoRedSocial(DatoRedSocial datoRedSocial) {
        return null;
    }

    @Override
    public Mensaje actualizarDatoRedSocial(DatoRedSocial datoRedSocial) {
        return null;
    }

    @Override
    public Page<DatoRedSocial> listarDatoRedSocial(Integer numPagina, Integer tamPagina, Long postulanteId) {
        return null;
    }
}
