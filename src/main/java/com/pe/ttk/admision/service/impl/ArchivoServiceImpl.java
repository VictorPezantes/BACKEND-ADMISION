package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.MensajeData;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.repository.PostulanteRepository;
import com.pe.ttk.admision.service.ArchivoService;
import com.pe.ttk.admision.util.GuardarArchivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    PostulanteRepository postulanteRepository;

    GuardarArchivos guardarArchivos = new GuardarArchivos();

    @Override
    public MensajeData<String> obtenerFotoPostulante(Long postulanteId) {
        MensajeData<String> data = new MensajeData<>();
        try {
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(postulanteId);
            if(postulanteEntity.isEmpty()) {
                data.setExito(false);
                data.setMensaje("Postulante no existe");
                return data;
            }
            data = guardarArchivos.obtenerArchivo("archivos/Postulante/",postulanteEntity.get().getFoto());
        }catch (Exception e) {
            data.setExito(false);
            data.setMensaje("Error: " + e.getMessage());
        }

        return data;
    }
}
