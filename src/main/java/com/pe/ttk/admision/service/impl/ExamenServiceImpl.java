package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.ExamenActDto;
import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.ExamenEntity;
import com.pe.ttk.admision.entity.admision.ExamenHistorialEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import com.pe.ttk.admision.repositoy.*;
import com.pe.ttk.admision.service.security.EmailService;
import com.pe.ttk.admision.service.ExamenService;
import com.pe.ttk.admision.util.Constantes;
import com.pe.ttk.admision.util.GuardarArchivos;
import com.pe.ttk.admision.util.mapper.ExamenMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    CentroMedicoRepository centroMedicoRepository;

    @Autowired
    TipoExamenRepository tipoExamenRepository;

    @Autowired
    PostulanteRepository postulanteRepository;

    @Autowired
    SubEstadoRepository subEstadoRepository;

    @Autowired
    ExamenRepository examenRepository;

    @Autowired
    ExamenMapper examenMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    ExamenHistorialRepository examenHistorialRepository;

    @Autowired
    ResultadoExamenRepository resultadoExamenRepository;
    private GuardarArchivos guardarArchivos = new GuardarArchivos();
    @Override
    public Mensaje registrarExamen(ExamenDto examenDto) {
        try{
            Optional<CentroMedico> centroMedicoDb = centroMedicoRepository.findById(examenDto.getCentroMedicoId());
            if (centroMedicoDb.isEmpty()){
                return new Mensaje("centro médico no existe",false);
            }

            Optional<TipoExamen> tipoExamenDb = tipoExamenRepository.findById(examenDto.getTipoExamenId());
            if (tipoExamenDb.isEmpty()){
                return new Mensaje("tipo de examen no existe",false);
            }
            Optional<SubEstado> subEstadoDb = subEstadoRepository.findById(SubEstadoNombre.PROGRAMADO.getValue());
            if (subEstadoDb.isEmpty()){
                return new Mensaje("Error al obtener el subEstado",false);
            }


            for (Long id : examenDto.getListaPostulante()){

                ExamenEntity examenEntity = examenMapper.toExamenEntity(examenDto);
                examenEntity.setCentroMedico(centroMedicoDb.get());
                examenEntity.setTipoExamen(tipoExamenDb.get());
                examenEntity.setSubEstado(subEstadoDb.get());

                Optional<PostulanteEntity> postulanteEntityDb = postulanteRepository.findById(id);
                if (postulanteEntityDb.isEmpty()){
                    return new Mensaje("postulante no existe",false);
                }

                examenEntity.setPostulante(postulanteEntityDb.get());

                examenRepository.save(examenEntity);
                StringBuilder mensaje1 = new StringBuilder(1000);
                String asunto = "Examen programado";
                mensaje1.append("Fecha y Hora: ").append(examenEntity.getFechaProgramada().toString()).append("\n");
                mensaje1.append("TipoExamen: ").append(tipoExamenDb.get().getTipoExamenNombre().toString()).append("\n");
                mensaje1.append("Centro Médico: ").append(centroMedicoDb.get().getCentroMedicoNombre().toString()).append("\n");
                mensaje1.append("Dirección: ").append(centroMedicoDb.get().getDireccion()).append("\n");
                mensaje1.append("Indicaciones: ").append("\n");
                mensaje1.append("\t").append("Ir en ayunas").append("\n");
                mensaje1.append("\t").append("No haber ingerido bebidas alcoholicas 24 horas antes del examen").append("\n");
                mensaje1.append("\t").append("No haber consumido estupefacientes").append("\n");

                emailService.enviarEmailExamen(postulanteEntityDb.get().getEmail(), mensaje1.toString(), asunto, postulanteEntityDb.get().getPrimerNombre());

                StringBuilder mensaje2 = new StringBuilder(1000);
                mensaje2.append("Nombre postulante: ").append(postulanteEntityDb.get().getApellidoPaterno()).append(" ").append(postulanteEntityDb.get().getPrimerNombre()).append("\n");
                mensaje2.append("Fecha y Hora: ").append(examenEntity.getFechaProgramada().toString()).append("\n");
                mensaje2.append("TipoExamen: ").append(tipoExamenDb.get().getTipoExamenNombre().toString()).append("\n");

                //emailService.enviarEmailExamen(centroMedicoDb.get().getEmail(), mensaje2.toString(), asunto, postulanteEntityDb.get().getPrimerNombre());
                emailService.enviarEmailExamen("jhankarlo.smc@gmail.com", mensaje2.toString(), asunto, postulanteEntityDb.get().getPrimerNombre());
                ExamenHistorialEntity examenHistorialEntity = new ExamenHistorialEntity();
                examenHistorialEntity.setEstadoResultadoExamen(examenEntity.getEstadoResultadoExamen());
                examenHistorialEntity.setDni(postulanteEntityDb.get().getDni());
                examenHistorialEntity.setCentroMedico(centroMedicoDb.get());
                examenHistorialEntity.setPrimerNombre(postulanteEntityDb.get().getPrimerNombre());
                examenHistorialEntity.setSegundoNombre(postulanteEntityDb.get().getSegundoNombre());
                examenHistorialEntity.setApellidoPaterno(postulanteEntityDb.get().getApellidoPaterno());
                examenHistorialEntity.setApellidoMaterno(postulanteEntityDb.get().getPrimerNombre());
                examenHistorialEntity.setEmailNotificacionCentroMedico(centroMedicoDb.get().getEmail());
                examenHistorialEntity.setEmailNotificacionPostulante(postulanteEntityDb.get().getEmail());
                examenHistorialEntity.setObservacion(examenEntity.getObservacion());
                examenHistorialEntity.setTipoExamen(tipoExamenDb.get());
                examenHistorialEntity.setFechaProgramada(examenEntity.getFechaProgramada());
                examenHistorialEntity.setFechaNotificacion(examenEntity.getFecha());
                examenHistorialEntity.setFechaInformeMedico(examenEntity.getFechaInformeMedico());
                examenHistorialEntity.setSubEstado(subEstadoDb.get());
                examenHistorialRepository.save(examenHistorialEntity);
            }

        }catch(Exception ex){
            System.err.println(ex);
        }

        return new Mensaje("Se registró el examen",true);
    }

    @Override
    public Page<ExamenDto> listarExamenes(Integer numPagina, Integer tamPagina, String buscador, List subEstado, String fechaInformeMedico, String fechaProgramada) {
        return null;
    }

    @Override
    public Mensaje reprogramarExamen(ExamenActDto examenActDto) {

        Optional<ExamenEntity> examenEntityDb = examenRepository.findById(examenActDto.getId());
        //validación de proceso reprogramar
        if(examenEntityDb.isEmpty()){
            return new Mensaje("El examen no existe",false);
        }
        ExamenEntity examenEntity = examenEntityDb.get();
        if(examenActDto.getSubEstadoId() == null){
            return new Mensaje("Sub estado vacío",false);
        }
        Optional<SubEstado> subEstadoActDb = subEstadoRepository.findById(examenActDto.getSubEstadoId());
        if (subEstadoActDb.isEmpty()){
            return new Mensaje("Sub estado a actualizar no existe",false);
        }
        if((examenEntity.getSubEstado().getSubEstadoNombre() != SubEstadoNombre.PROGRAMADO
                && examenEntity.getSubEstado().getSubEstadoNombre() != SubEstadoNombre.OBSERVADO)
                && subEstadoActDb.get().getSubEstadoNombre() == SubEstadoNombre.REPROGRAMADO
                && examenActDto.getFechaProgramada() != null){
            return new Mensaje("Para poder reprogramar el estado del examen tiene que estar en programado o observado",false);
        }

        Optional<SubEstado> subEstadoDb = subEstadoRepository.findById(SubEstadoNombre.REPROGRAMADO.getValue());
        if (subEstadoDb.isEmpty()){
            return new Mensaje("Sub estado no existe",false);
        }
        Optional<CentroMedico> centroMedicoDb = centroMedicoRepository.findById(examenActDto.getCentroMedicoId());
        if (centroMedicoDb.isEmpty()){
            return new Mensaje("centro médico no existe",false);
        }
        if(subEstadoDb.get().getSubEstadoNombre() == SubEstadoNombre.DESAPROBADO){
            //Optional<PostulanteEntity> postulanteEntityDb = postulanteRepository.findById(examenEntity.getPostulante().getId());
            //postulanteEntityDb.get().setEstado(Constantes.ESTADO_FUERA_DEL_PROCESO);
        }
        examenEntity.setCentroMedico(centroMedicoDb.get());
        examenEntity.setSubEstado(subEstadoDb.get());
        examenEntity.setFechaProgramada(examenActDto.getFechaProgramada());
        return new Mensaje("Se actualizó de manera correcta",true);
    }

    @Override
    public Mensaje cancelarExamen(Long examenId, boolean solicitudPostulante) {

        Optional<ExamenEntity> examenEntityDb = examenRepository.findById(examenId);

        if(examenEntityDb.isEmpty()){
            return new Mensaje("El examen no existe",false);
        }
        ExamenEntity examenEntity = examenEntityDb.get();
        Date hoy = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(examenEntity.getFechaProgramada());
        cal.add(Calendar.DATE, Constantes.DIAS_CANCELACION);
        Date fechaVencimiento = cal.getTime();
        if(fechaVencimiento.getTime() > hoy.getTime() && !solicitudPostulante){
            return new Mensaje("El examen no se puede cancelar aún",false);
        }
        if(examenEntity.getResultadoExamen()!= null && !solicitudPostulante){
            return new Mensaje("El examen con resultado no puede eliminarse",false);
        }

        Optional<SubEstado> subEstadoDb = subEstadoRepository.findById(SubEstadoNombre.CANCELADO.getValue());
        examenEntity.setSubEstado(subEstadoDb.get());
        return new Mensaje("Examen cancelado exitosamente",true);
    }

    @Override
    public Mensaje registrarResultadoExamen(Long examenId,Integer estadoResultadoExamenId, MultipartFile resultadoExamen,Date fechaResultado) {

        Optional<ExamenEntity> examenEntityDb = examenRepository.findById(examenId);
        if(examenEntityDb.isEmpty()){
            return new Mensaje("El examen no existe",false);
        }
        Optional<EstadoResultadoExamen> estadoResultadoExamenDb = resultadoExamenRepository.findById(estadoResultadoExamenId);
        if(estadoResultadoExamenDb.isEmpty()){
            return new Mensaje("El sub estado de resultado no existe",false);
        }
        Optional<PostulanteEntity> postulanteEntityDb = postulanteRepository.findById(examenEntityDb.get().getPostulante().getId());
        String nombreResultadoExamen = postulanteEntityDb.get().getDni()+"_"+examenId+"."+ FilenameUtils.getExtension(resultadoExamen.getOriginalFilename());

        guardarArchivos.guardarArchivo(resultadoExamen, nombreResultadoExamen, "archivos/Examen");
        examenEntityDb.get().setResultadoExamen(nombreResultadoExamen);
        examenEntityDb.get().setEstadoResultadoExamen(estadoResultadoExamenDb.get());
        examenEntityDb.get().setFechaResultado(fechaResultado);
        return new Mensaje("Resultado se guardó de manera correcta",true);
    }

    @Override
    public Mensaje actualizarSubEstadoExamen(Long examenId, Integer estado) {
        if(examenId == null){
            return new Mensaje("ExamenId null",false);
        }
        if(estado == null){
            return new Mensaje("estado null",false);
        }
        Optional<ExamenEntity> examenEntityDb = examenRepository.findById(examenId);
        if(examenEntityDb.isEmpty()){
            return new Mensaje("El examen no existe",false);
        }
        Optional<SubEstado> subEstadoDb = subEstadoRepository.findById(SubEstadoNombre.REPROGRAMADO.getValue());
        if (subEstadoDb.isEmpty()){
            return new Mensaje("Sub estado no existe",false);
        }
        examenEntityDb.get().setSubEstado(subEstadoDb.get());
        return new Mensaje("Estado actualizado exitosamente",true);
    }
}
