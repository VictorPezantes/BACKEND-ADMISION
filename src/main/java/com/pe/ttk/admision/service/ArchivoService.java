package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.MensajeData;

public interface ArchivoService {
    MensajeData<String> obtenerFotoPostulante(Long postulanteId);
}
