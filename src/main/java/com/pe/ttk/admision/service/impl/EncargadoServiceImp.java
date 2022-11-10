package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.EncargadoDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.repository.EncargadoRepository;
import com.pe.ttk.admision.repository.PostulanteRepository;
import com.pe.ttk.admision.service.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EncargadoServiceImp implements EncargadoService {

    @Autowired
    private EncargadoRepository encargadoRepository;

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public List<Encargado> listaEncargados() {
        return encargadoRepository.findAll();
    }

    @Override
    public void registrarEncargado(Encargado encargado) {

        encargadoRepository.save(encargado);

    }

    @Override
    public void eliminarEncargado(Long id) {
        encargadoRepository.deleteById(id);
    }

    @Override
    public void actualizarEncargado(Long id, Encargado encargado) {

        Encargado encargadoOferta = getOne(id).get();
        encargadoOferta.setNombre(encargado.getNombre());
        encargadoOferta.setApellido(encargado.getApellido());
        encargadoOferta.setEmail(encargado.getEmail());
        encargadoOferta.setTelefono(encargado.getTelefono());
        encargadoRepository.save(encargadoOferta);
    }

    @Override
    public Optional<Encargado> getOne(Long id) {
        return encargadoRepository.findById( id);
    }

    @Override
    public boolean existsByEmail(String email) {

        return encargadoRepository.existsByEmail(email);
    }

    @Override
    public Mensaje registrarEncargadoPostulante(EncargadoDto encargadoDto) {
        Optional<Encargado> encargadoBd = encargadoRepository.findById( encargadoDto.getEncargadoId());
        if(encargadoBd.isEmpty()){
            return new Mensaje("El encargado no existe",false);
        }
        List<PostulanteEntity> postulanteEntityList = new ArrayList<>();
        for (Long postulanteId : encargadoDto.getPostulantes()){
            Optional<PostulanteEntity> postulanteEntityBd = postulanteRepository.findById( postulanteId);
            if(postulanteEntityBd.isEmpty()){
                return new Mensaje("El postulante no existe",false);
            }
            postulanteEntityBd.get().setEncargado(encargadoBd.get());
        }
        return new Mensaje("Se asignó el/los postulante(s) con éxito",true);
    }
}
