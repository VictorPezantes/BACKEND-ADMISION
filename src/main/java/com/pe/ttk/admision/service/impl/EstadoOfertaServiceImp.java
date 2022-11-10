package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.entity.master.EstadoOferta;
import com.pe.ttk.admision.enums.EstadoOfertaNombre;
import com.pe.ttk.admision.enums.EstadoPostulanteNombre;
import com.pe.ttk.admision.repository.EstadoOfertaRepository;
import com.pe.ttk.admision.service.EstadoOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstadoOfertaServiceImp implements EstadoOfertaService {

    @Autowired
    private EstadoOfertaRepository estadoOfertaRepository;

    @Override
    public List<EstadoOferta> listaEstados() {
        return estadoOfertaRepository.findAll();
    }

    public void save(EstadoOferta estadoOferta) {

        estadoOfertaRepository.save(estadoOferta);
    }

    @Override
    public void eliminarEstado(Integer id) {
        estadoOfertaRepository.deleteById(id);
    }

    @Override
    public void actualizarEstado(Integer id, EstadoOferta estado) {

        EstadoOferta estadoOferta = getOne(id).get();
        estadoOferta.setEstado(estado.getEstado());
        estadoOfertaRepository.save(estadoOferta);
    }
    @Override
    public Optional<EstadoOferta> getOne(Integer id) {
        return estadoOfertaRepository.findById( id);
    }

    @Override
    public Optional<EstadoOfertaNombre> findAllByEstadoOfertaNombre(EstadoOfertaNombre estadoOfertaNombre) {
        return estadoOfertaRepository.findAllByEstadoOfertaNombre(estadoOfertaNombre);
    }

}
