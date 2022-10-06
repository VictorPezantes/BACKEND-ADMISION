package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.repositoy.ResultadoExamenRepository;
import com.pe.ttk.admision.dto.entity.master.ResultadoExamen;
import com.pe.ttk.admision.enums.ResultadoExamenNombre;
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
    public Optional<ResultadoExamen> findByResultadoExamenNombre(ResultadoExamenNombre resultadoExamenNombre) {
        return resultadoExamenRepository.findByResultadoExamenNombre(resultadoExamenNombre);
    }

    @Override
    public void save(ResultadoExamen resultadoExamen) {
        resultadoExamenRepository.save(resultadoExamen);
    }
}
