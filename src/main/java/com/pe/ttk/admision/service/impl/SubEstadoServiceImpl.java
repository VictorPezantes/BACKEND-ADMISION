package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.repositoy.SubEstadoRepository;
import com.pe.ttk.admision.dto.entity.master.SubEstado;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import com.pe.ttk.admision.service.SubEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class SubEstadoServiceImpl implements SubEstadoService {

    @Autowired
    SubEstadoRepository subEstadoRepository;

    @Override
    public Optional<SubEstado> findBySubEstadoNombre(SubEstadoNombre subEstadoNombre) {
        return subEstadoRepository.findBySubEstadoNombre(subEstadoNombre);
    }

    @Override
    public void save(SubEstado subEstado) {
        subEstadoRepository.save(subEstado);
    }
}
