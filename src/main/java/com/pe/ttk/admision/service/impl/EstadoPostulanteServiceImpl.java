package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.entity.master.EstadoPostulante;
import com.pe.ttk.admision.enums.EstadoPostulanteNombre;
import com.pe.ttk.admision.repository.EstadoPostulanteRepository;
import com.pe.ttk.admision.service.EstadoPostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstadoPostulanteServiceImpl implements EstadoPostulanteService {
    @Autowired
    EstadoPostulanteRepository estadoPostulanteRepository;

    @Override
    public Optional<EstadoPostulanteNombre> findAllByEstadoPostulanteNombre(EstadoPostulanteNombre estadoPostulanteNombre) {
        return estadoPostulanteRepository.findAllByEstadoPostulanteNombre(estadoPostulanteNombre);
    }

    @Override
    public void save(EstadoPostulante estadoPostulante) {
        estadoPostulanteRepository.save(estadoPostulante);
    }

    @Override
    public Optional<EstadoPostulante> findById(Integer id) {
        return estadoPostulanteRepository.findById(id);
    }

    @Override
    public List<EstadoPostulante> listar() {
        return estadoPostulanteRepository.findAll();
    }
}
