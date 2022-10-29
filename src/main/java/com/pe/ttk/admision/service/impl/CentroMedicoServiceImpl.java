package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.repositoy.CentroMedicoRepository;
import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.enums.CentroMedicoNombre;
import com.pe.ttk.admision.service.CentroMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CentroMedicoServiceImpl implements CentroMedicoService {

    @Autowired
    CentroMedicoRepository centroMedicoRepository;

    @Override
    public Optional<CentroMedicoNombre> findAllByCentroMedicoNombre(CentroMedicoNombre centroMedicoNombre) {
        return centroMedicoRepository.findAllByCentroMedicoNombre(centroMedicoNombre);
    }

    @Override
    public void save(CentroMedico centroMedico) {
        centroMedicoRepository.save(centroMedico);
    }

    @Override
    public Optional<CentroMedico> findById(Integer id) {
        return centroMedicoRepository.findById(id);
    }

    @Override
    public List<CentroMedico> listar() {
        return centroMedicoRepository.findAll();
    }
}
