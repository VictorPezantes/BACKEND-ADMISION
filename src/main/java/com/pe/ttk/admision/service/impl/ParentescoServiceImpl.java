package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.Parentesco;
import com.pe.ttk.admision.enums.ParentescoNombre;
import com.pe.ttk.admision.repository.ParentescoRepository;
import com.pe.ttk.admision.service.ParentescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ParentescoServiceImpl implements ParentescoService {
    @Autowired
    ParentescoRepository parentescoRepository;

    @Override
    public Optional<ParentescoNombre> findAllByParentescoNombre(ParentescoNombre parentescoNombre) {
        return parentescoRepository.findAllByParentescoNombre(parentescoNombre);
    }

    @Override
    public List<Parentesco> listar() {
        return parentescoRepository.findAll();
    }

    @Override
    public void save(Parentesco parentesco) {
        parentescoRepository.save(parentesco);
    }
}
