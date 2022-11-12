package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.MensajeData;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.repository.PostulanteRepository;
import com.pe.ttk.admision.service.ArchivoService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Optional;

@Service
@Transactional
public class ArchivoServiceImpl implements ArchivoService {

    private static final Logger logger = LoggerFactory.getLogger(ArchivoServiceImpl.class);
    private final Path rootFolder = Paths.get("archivos/Postulante");
    private final String directorio = new File("archivos/Postulante").getAbsolutePath();
    public void init(Path path) {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void guardarArchivo(MultipartFile curriculum, MultipartFile dniFrontal, MultipartFile dniPosterior, MultipartFile foto, String nombreCurriculum, String nombreDniFrontal, String nombreDniPosterior, String nombreFoto) {
        try {
            File file = new File(directorio);
            if(!file.isDirectory()){
                init(this.rootFolder);
            }
            Files.copy(curriculum.getInputStream(), this.rootFolder.resolve(nombreCurriculum), StandardCopyOption.REPLACE_EXISTING);

            Files.copy(dniFrontal.getInputStream(), this.rootFolder.resolve(nombreDniFrontal), StandardCopyOption.REPLACE_EXISTING);

            Files.copy(dniPosterior.getInputStream(), this.rootFolder.resolve(nombreDniPosterior), StandardCopyOption.REPLACE_EXISTING);

            Files.copy(foto.getInputStream(), this.rootFolder.resolve(nombreFoto), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void guardarArchivo(MultipartFile archivo, String nombreArchivo, String folder) {
        String carpeta = new File(folder).getAbsolutePath();
        try {
            Path path = Paths.get(folder);
            File file = new File(carpeta);
            if(!file.isDirectory()){
                init(path);
            }
            Files.copy(archivo.getInputStream(), path.resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);

        }catch(IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void guardarArchivo(MultipartFile archivo, String nombreArchivo) {
        try {
            File file = new File(directorio);
            if(!file.isDirectory()){
                init(this.rootFolder);
            }
            Files.copy(archivo.getInputStream(), this.rootFolder.resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);

        }catch(IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public MensajeData<String> obtenerArchivoBase64(String directorio, String nombreArchivo) {
        MensajeData<String> respuesta = new MensajeData<String>();
        try {
            File archivo = new File(directorio+nombreArchivo);
            if(archivo == null)
            {
                respuesta.setExito(false);
                respuesta.setMensaje("no se encontró el archivo");
            }
            InputStream in = new FileInputStream(archivo);
            if(in == null)
            {
                respuesta.setExito(false);
                respuesta.setMensaje("error al leer el archivo");
            }
            respuesta.setExito(true);
            respuesta.setMensaje("El archivo se obtuvo con éxito");
            respuesta.setData(Base64.getEncoder().encodeToString(IOUtils.toByteArray(in)));
        }catch(IOException e){
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    @Override
    public MensajeData<byte[]> obtenerArchivoByteArray(String directorio, String nombreArchivo) {
        MensajeData<byte[]> respuesta = new MensajeData<byte[]>();
        try {
            File archivo = new File(directorio+nombreArchivo);
            if(archivo == null)
            {
                respuesta.setExito(false);
                respuesta.setMensaje("no se encontró el archivo");
            }
            InputStream in = new FileInputStream(archivo);
            if(in == null)
            {
                respuesta.setExito(false);
                respuesta.setMensaje("error al leer el archivo");
            }
            respuesta.setExito(true);
            respuesta.setMensaje("El archivo se obtuvo con éxito");
            respuesta.setData(IOUtils.toByteArray(in));
        }catch(IOException e){
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    @Override
    public void actualizarArchivo(MultipartFile dnifrontal, MultipartFile dniposterior, MultipartFile foto) {
        try {
            if(dnifrontal != null){
                Files.copy(dnifrontal.getInputStream(), this.rootFolder.resolve(dnifrontal.getOriginalFilename()));
            }
            if(dniposterior != null){
                Files.copy(dniposterior.getInputStream(), this.rootFolder.resolve(dniposterior.getOriginalFilename()));
            }
            if(foto != null){
                Files.copy(foto.getInputStream(), this.rootFolder.resolve(foto.getOriginalFilename()));
            }
        }catch(IOException e){
            logger.error(e.getMessage());
        }
    }
}
