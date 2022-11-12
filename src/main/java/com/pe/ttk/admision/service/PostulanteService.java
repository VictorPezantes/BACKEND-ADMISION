package com.pe.ttk.admision.service;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.MensajeData;
import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface PostulanteService {



    List<PostulanteEntity> list();
    List<PostulanteDto> findByQueryString(String estadoPostulacion,String distrito, String provincia, String departamento,String profesion,String responsableAsignado,String procedencia,
                                                        String apellidoPaterno);

    PostulanteDto findByDni(String dni);

    Mensaje registrarPostulante(PostulanteDto postulanteDto, MultipartFile cv, MultipartFile dniF, MultipartFile dniP, MultipartFile foto);
    Mensaje UpdatePostulante(PostulanteDto postulanteDto, MultipartFile dnifrontal, MultipartFile dniposterior, MultipartFile foto,MultipartFile curriculum);

    void delete(int id);
    Optional<PostulanteEntity> getOne(int id);

    Page<PostulanteDto> listarPostulantes(Integer numPagina, Integer tamPagina);
    Page<PostulanteDto> listarPostulanteFiltro(Integer numPagina, Integer tamPagina, Integer estado, Integer subEstadoExamen, Date fechaInformeMedico, Date fechaProgramada, String filtro, Long encargadoId,Long cargoId);
    MensajeData<String> obtenerCurriculumPostulanteBase64(Long postulanteId);
    MensajeData<byte[]> obtenerCurriculumPostulanteByte(Long postulanteId);
    MensajeData<String> obtenerFotoPostulanteBase64(Long postulanteId);
    Mensaje enviarCVPorCorreo(Long postulanteId, List<String> correos);
}
