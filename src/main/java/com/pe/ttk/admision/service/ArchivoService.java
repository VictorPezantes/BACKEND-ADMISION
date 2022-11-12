package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.MensajeData;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivoService {
    public void guardarArchivo(MultipartFile curriculum, MultipartFile dniFrontal, MultipartFile dniPosterior, MultipartFile foto,
                               String nombreCurriculum, String nombreDniFrontal, String nombreDniPosterior, String nombreFoto);
    void guardarArchivo(MultipartFile archivo, String nombreArchivo, String folder);
    void guardarArchivo(MultipartFile archivo, String nombreArchivo);
    MensajeData<String> obtenerArchivoBase64(String directorio, String nombreArchivo);
    MensajeData<byte[]> obtenerArchivoByteArray(String directorio, String nombreArchivo);
    void actualizarArchivo( MultipartFile dnifrontal, MultipartFile dniposterior, MultipartFile foto);
}
