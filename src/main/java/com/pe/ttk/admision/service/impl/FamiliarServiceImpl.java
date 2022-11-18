package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.FamiliarDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.entity.admision.Familiar;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.Departamento;
import com.pe.ttk.admision.entity.master.Distrito;
import com.pe.ttk.admision.entity.master.Parentesco;
import com.pe.ttk.admision.entity.master.Provincia;
import com.pe.ttk.admision.repository.*;
import com.pe.ttk.admision.service.FamiliarService;
import com.pe.ttk.admision.util.mapper.FamiliarMapper;
import com.pe.ttk.admision.util.mapper.impl.PostulanteMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
public class FamiliarServiceImpl implements FamiliarService {
    @Autowired
    FamiliarRepository familiarRepository;

    @Autowired
    ParentescoRepository parentescoRepository;

    @Autowired
    DistritoRepository distritoRepository;

    @Autowired
    ProvinciaRepository provinciaRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    PostulanteRepository postulanteRepository;

    @Autowired
    FamiliarMapper familiarMapper;

    @Override
    public Mensaje registrar(FamiliarDto familiarDto) {
        Familiar familiar = new Familiar();
        familiar.setPrimerApellido(familiarDto.getPrimerApellido());
        familiar.setSegundoApellido(familiarDto.getSegundoApellido());
        familiar.setPrimerNombre(familiarDto.getPrimerNombre());
        familiar.setSegundoNombre(familiarDto.getSegundoNombre());
        familiar.setDni(familiarDto.getDni());
        familiar.setFechaNacimiento(familiarDto.getFechaNacimiento());
        familiar.setOcupacion(familiarDto.getOcupacion());
        familiar.setDireccion(familiarDto.getDireccion());

        Optional<Parentesco> parentesco = parentescoRepository.findById(familiarDto.getParentescoId());
        if (parentesco.isEmpty()){
            return new Mensaje("No existe parentesco",false);
        }
        familiar.setParentesco(parentesco.get());

        Optional<Distrito> distrito = distritoRepository.findById(familiarDto.getDistritoId());
        if (distrito.isEmpty()){
            return new Mensaje("No existe distrito",false);
        }
        familiar.setDistrito(distrito.get());

        Optional<Provincia> provincia = provinciaRepository.findById(familiarDto.getProvinciaId());
        if (provincia.isEmpty()){
            return new Mensaje("No existe provincia",false);
        }
        familiar.setProvincia(provincia.get());

        Optional<Departamento> departamento = departamentoRepository.findById(familiarDto.getDepartamentoId());
        if (departamento.isEmpty()){
            return new Mensaje("No existe departamento",false);
        }
        familiar.setDepartamento(departamento.get());

        Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(familiarDto.getPostulanteId());
        if (postulanteEntity.isEmpty()){
            return new Mensaje("No existe postulante",false);
        }
        familiar.setPostulante(postulanteEntity.get());

        familiarRepository.save(familiar);
        return new Mensaje("Se registró con éxito",true);
    }

    @Override
    public Mensaje actualizar(FamiliarDto familiarDto) {

        Optional<Familiar> familiarDb = familiarRepository.findById(familiarDto.getId());
        if(familiarDb.isEmpty()){
            return new Mensaje("familiar no existe",false);
        }

        if(familiarDto.getPrimerApellido() != null){
            familiarDb.get().setPrimerApellido(familiarDto.getPrimerApellido());
        }
        if(familiarDto.getSegundoApellido() != null){
            familiarDb.get().setSegundoApellido(familiarDto.getSegundoApellido());
        }
        if(familiarDto.getPrimerNombre() != null){
            familiarDb.get().setPrimerNombre(familiarDto.getPrimerNombre());
        }
        if(familiarDto.getSegundoNombre() != null){
            familiarDb.get().setSegundoNombre(familiarDto.getSegundoNombre());
        }
        if(familiarDto.getDni() != null){
            familiarDb.get().setDni(familiarDto.getDni());
        }
        if(familiarDto.getFechaNacimiento() != null){
            familiarDb.get().setFechaNacimiento(familiarDto.getFechaNacimiento());
        }
        if(familiarDto.getOcupacion()!= null){
            familiarDb.get().setOcupacion(familiarDto.getOcupacion());
        }
        if(familiarDto.getDireccion()!= null){
            familiarDb.get().setDireccion(familiarDto.getDireccion());
        }
        if(familiarDto.getParentescoId() != null){
            Optional<Parentesco> parentesco = parentescoRepository.findById(familiarDto.getParentescoId());
            if (parentesco.isEmpty()){
                return new Mensaje("No existe parentesco",false);
            }
            familiarDb.get().setParentesco(parentesco.get());
        }
        if(familiarDto.getDistritoId() != null){
            Optional<Distrito> distrito = distritoRepository.findById(familiarDto.getDistritoId());
            if (distrito.isEmpty()){
                return new Mensaje("No existe distrito",false);
            }
            familiarDb.get().setDistrito(distrito.get());
        }
        if(familiarDto.getProvinciaId() != null){
            Optional<Provincia> provincia = provinciaRepository.findById(familiarDto.getProvinciaId());
            if (provincia.isEmpty()){
                return new Mensaje("No existe provincia",false);
            }
            familiarDb.get().setProvincia(provincia.get());
        }

        if(familiarDto.getDepartamentoId() != null){
            Optional<Departamento> departamento = departamentoRepository.findById(familiarDto.getDepartamentoId());
            if (departamento.isEmpty()){
                return new Mensaje("No existe departamento",false);
            }
            familiarDb.get().setDepartamento(departamento.get());
        }
        if(familiarDto.getPostulanteId()!= null){
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(familiarDto.getPostulanteId());
            if (postulanteEntity.isEmpty()){
                return new Mensaje("No existe postulante",false);
            }
            familiarDb.get().setPostulante(postulanteEntity.get());
        }

        return new Mensaje("Se actualizó con éxito",true);
    }

    @Override
    public Page<FamiliarDto> listar(Integer numPagina, Integer tamPagina, Long postulanteId) {
        Pageable pageable = PageRequest.of(numPagina, tamPagina);
        List<Familiar> lista = familiarRepository.listar(postulanteId, pageable);
        List<FamiliarDto> listaFamiliares = lista.stream().map(familiarMapper.INSTANCE::toFamiliarDto).collect(Collectors.toList());
        if(!lista.isEmpty()){
            return new PageImpl<>(listaFamiliares, pageable, lista.size());
        }
        return null;
    }
}
