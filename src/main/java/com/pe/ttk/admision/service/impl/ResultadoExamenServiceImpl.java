package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.repositoy.ResultadoExamenRepository;
import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.enums.EstadoResultadoExamenNombre;
import com.pe.ttk.admision.service.ResultadoExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class ResultadoExamenServiceImpl implements ResultadoExamenService {

    @Autowired
    ResultadoExamenRepository resultadoExamenRepository;

    @Override
    public Optional<EstadoResultadoExamenNombre> findByResultadoExamenNombre(EstadoResultadoExamenNombre resultadoExamenNombre) {
        return resultadoExamenRepository.findByResultadoExamenNombre(resultadoExamenNombre);
    }

    @Override
    public void save(EstadoResultadoExamen estadoResultadoExamen) {
        resultadoExamenRepository.save(estadoResultadoExamen);
    }
}
