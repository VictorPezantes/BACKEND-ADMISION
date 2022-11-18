package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.entity.master.NivelEstudio;
import com.pe.ttk.admision.enums.NivelEstudioNombre;
import com.pe.ttk.admision.repository.NivelEstudioRepository;
import com.pe.ttk.admision.service.NivelEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NivelEstudioServiceImpl implements NivelEstudioService {

    @Autowired
    NivelEstudioRepository nivelEstudioRepository;

    @Override
    public Optional<NivelEstudioNombre> findByNivelEstudioNombre(NivelEstudioNombre nivelEstudioNombre) {
        return nivelEstudioRepository.findByNivelEstudioNombre(nivelEstudioNombre);
    }

    @Override
    public void save(NivelEstudio nivelEstudio) {
        nivelEstudioRepository.save(nivelEstudio);
    }

    @Override
    public List<NivelEstudio> listar() {
        return nivelEstudioRepository.findAll();
    }
}
