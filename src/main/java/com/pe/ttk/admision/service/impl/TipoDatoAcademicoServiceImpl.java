package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.entity.master.TipoDatoAcademico;
import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.TipoDatoAcademicoNombre;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import com.pe.ttk.admision.repository.TipoDatoAcademicoRepository;
import com.pe.ttk.admision.service.TipoDatoAcademicoService;
import com.pe.ttk.admision.service.TipoExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoDatoAcademicoServiceImpl implements TipoDatoAcademicoService {

    @Autowired
    TipoDatoAcademicoRepository tipoDatoAcademicoRepository;

    @Override
    public Optional<TipoDatoAcademicoNombre> findByTipoDatoAcademicoNombre(TipoDatoAcademicoNombre tipoDatoAcademicoNombre) {
        return tipoDatoAcademicoRepository.findByTipoDatoAcademicoNombre(tipoDatoAcademicoNombre);
    }

    @Override
    public void save(TipoDatoAcademico tipoDatoAcademico) {
        tipoDatoAcademicoRepository.save(tipoDatoAcademico);
    }

    @Override
    public List<TipoDatoAcademico> listar() {
        return tipoDatoAcademicoRepository.findAll();
    }
}
