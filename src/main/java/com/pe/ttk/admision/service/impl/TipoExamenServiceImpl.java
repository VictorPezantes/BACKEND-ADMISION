package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.repositoy.TipoExamenRepository;
import com.pe.ttk.admision.dto.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import com.pe.ttk.admision.service.TipoExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class TipoExamenServiceImpl implements TipoExamenService {

    @Autowired
    TipoExamenRepository tipoExamenRepository;

    @Override
    public Optional<TipoExamenNombre> findByTipoExamenNombre(TipoExamenNombre tipoExamenNombre) {
        return tipoExamenRepository.findByTipoExamenNombre(tipoExamenNombre);
    }

    @Override
    public void save(TipoExamen tipoExamen) {
        tipoExamenRepository.save(tipoExamen);
    }
}
