package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.ExamenActDto;
import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.ExamenEntity;
import com.pe.ttk.admision.entity.admision.HistorialExamen;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import com.pe.ttk.admision.repository.*;
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
    HistorialExamenRepository historialExamenRepository;

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
                Date fechaEnvioEmail = new Date(System.currentTimeMillis());
                emailService.enviarEmailExamen(postulanteEntityDb.get().getEmail(), mensaje1.toString(), asunto, postulanteEntityDb.get().getPrimerNombre());

                StringBuilder mensaje2 = new StringBuilder(1000);
                mensaje2.append("Nombre postulante: ").append(postulanteEntityDb.get().getApellidoPaterno()).append(" ").append(postulanteEntityDb.get().getPrimerNombre()).append("\n");
                mensaje2.append("Fecha y Hora: ").append(examenEntity.getFechaProgramada().toString()).append("\n");
                mensaje2.append("TipoExamen: ").append(tipoExamenDb.get().getTipoExamenNombre().toString()).append("\n");

                //emailService.enviarEmailExamen(centroMedicoDb.get().getEmail(), mensaje2.toString(), asunto, postulanteEntityDb.get().getPrimerNombre());
                emailService.enviarEmailExamen("jhankarlo.smc@gmail.com", mensaje2.toString(), asunto, postulanteEntityDb.get().getPrimerNombre());
                HistorialExamen historialExamen = new HistorialExamen();
                historialExamen.setExamen(examenEntity);
                historialExamen.setPostulante(postulanteEntityDb.get());
                historialExamen.setFechaProgramada(examenEntity.getFechaProgramada());
                historialExamen.setSubEstado(subEstadoDb.get());
                historialExamen.setFechaInformeMedico(examenEntity.getFechaInformeMedico());
                historialExamen.setTipoExamen(tipoExamenDb.get());
                historialExamen.setObservaciones(examenEntity.getObservacion());
                historialExamen.setEmailNotificacion(postulanteEntityDb.get().getEmail());
                historialExamen.setFechaNotificacion(fechaEnvioEmail);
                historialExamen.setCentroMedico(centroMedicoDb.get());
                historialExamen.setFechaCambioEstado(new Date(System.currentTimeMillis()));
                historialExamenRepository.save(historialExamen);
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
    public Mensaje actualizarExamen(ExamenActDto examenActDto) {

        Optional<ExamenEntity> examenEntityDb = examenRepository.findById(examenActDto.getId());

        if(examenEntityDb.isEmpty()){
            return new Mensaje("El examen no existe",false);
        }

        ExamenEntity examenEntity = examenEntityDb.get();
        HistorialExamen historialExamen = new HistorialExamen();
        if(examenActDto.getFechaProgramada() != null){
            examenEntity.setFechaProgramada(examenActDto.getFechaProgramada());
            historialExamen.setExamen(examenEntity);
            historialExamen.setFechaProgramada(examenActDto.getFechaProgramada());
        }

        if(examenActDto.getSubEstadoId() != null){

            Optional<SubEstado> subEstadoActDb = subEstadoRepository.findById(examenActDto.getSubEstadoId());
            if (subEstadoActDb.isEmpty()){
                return new Mensaje("Sub estado a actualizar no existe",false);
            }
            //validación reprogramar
            if(subEstadoActDb.get().getSubEstadoNombre() == SubEstadoNombre.REPROGRAMADO){
                if((examenEntity.getSubEstado().getSubEstadoNombre() != SubEstadoNombre.PROGRAMADO
                        && examenEntity.getSubEstado().getSubEstadoNombre() != SubEstadoNombre.OBSERVADO)
                        && subEstadoActDb.get().getSubEstadoNombre() == SubEstadoNombre.REPROGRAMADO
                        && examenActDto.getFechaProgramada() != null){
                    return new Mensaje("Para poder reprogramar el estado del examen tiene que estar en programado o observado",false);
                }
            }

            if(subEstadoActDb.get().getSubEstadoNombre() == SubEstadoNombre.CANCELADO) {
                Date hoy = new Date(System.currentTimeMillis());
                Calendar cal = Calendar.getInstance();
                cal.setTime(examenEntity.getFechaProgramada());
                cal.add(Calendar.DATE, Constantes.DIAS_CANCELACION);
                Date fechaVencimiento = cal.getTime();
                if(fechaVencimiento.getTime() > hoy.getTime() && !examenActDto.getSolicitudPostulante()){
                    return new Mensaje("El examen no se puede cancelar aún",false);
                }
                if(examenEntity.getResultadoExamen()!= null && !examenActDto.getSolicitudPostulante()){
                    return new Mensaje("El examen con resultado no puede eliminarse",false);
                }

                examenEntity.setSubEstado(subEstadoActDb.get());
                historialExamen.setExamen(examenEntity);
                historialExamen.setSubEstado(subEstadoActDb.get());
            }
            examenEntity.setSubEstado(subEstadoActDb.get());
            historialExamen.setExamen(examenEntity);
            historialExamen.setSubEstado(subEstadoActDb.get());
        }

        if(examenActDto.getFechaInformeMedico() != null){
            examenEntity.setFechaInformeMedico(examenActDto.getFechaInformeMedico());
            historialExamen.setExamen(examenEntity);
            historialExamen.setFechaInformeMedico(examenActDto.getFechaInformeMedico());
        }

        if(examenActDto.getTipoExamenId() != null){
            Optional<TipoExamen> tipoExamenDb = tipoExamenRepository.findById(examenActDto.getTipoExamenId());
            if (tipoExamenDb.isEmpty()){
                return new Mensaje("Tipo examen no existe",false);
            }
            examenEntity.setTipoExamen(tipoExamenDb.get());
            historialExamen.setExamen(examenEntity);
            historialExamen.setTipoExamen(tipoExamenDb.get());
        }

        if(examenActDto.getObservaciones() != null){
            examenEntity.setObservacion(examenActDto.getObservaciones());
            historialExamen.setExamen(examenEntity);
            historialExamen.setObservaciones(examenActDto.getObservaciones());
        }

        if(examenActDto.getCentroMedicoId() != null){
            Optional<CentroMedico> centroMedicoDb = centroMedicoRepository.findById(examenActDto.getCentroMedicoId());
            if (centroMedicoDb.isEmpty()){
                return new Mensaje("centro médico no existe",false);
            }
            examenEntity.setCentroMedico(centroMedicoDb.get());
            historialExamen.setExamen(examenEntity);
            historialExamen.setCentroMedico(centroMedicoDb.get());
        }

        if(examenActDto.getAutorizoGerencia() != null)
        {
            historialExamen.setExamen(examenEntity);
            historialExamen.setAutorizoGerencia(examenActDto.getAutorizoGerencia());
        }
        //registrar resultado

        if(examenActDto.getEstadoResultadoExamenId() != null && examenActDto.getResultadoExamen() != null && examenActDto.getFechaResultado() != null){
            Optional<EstadoResultadoExamen> estadoResultadoExamenDb = resultadoExamenRepository.findById(examenActDto.getEstadoResultadoExamenId());
            if (estadoResultadoExamenDb.isEmpty()){
                return new Mensaje("Estado de resultado no existe",false);
            }

            historialExamen.setExamen(examenEntity);
            examenEntity.setEstadoResultadoExamen(estadoResultadoExamenDb.get());

            Optional<PostulanteEntity> postulanteEntityDb = postulanteRepository.findById(examenEntity.getPostulante().getId());
            String nombreResultadoExamen = postulanteEntityDb.get().getDni()+"_"+examenActDto.getId()+"."+ FilenameUtils.getExtension(examenActDto.getResultadoExamen().getOriginalFilename());

            guardarArchivos.guardarArchivo(examenActDto.getResultadoExamen(), nombreResultadoExamen, "archivos/Examen");
            examenEntity.setResultadoExamen(nombreResultadoExamen);
            examenEntity.setFechaResultado(examenActDto.getFechaResultado());
        }
        else{
            return new Mensaje("Para actualizar el resultado del examen los datos de resultadoExamenId, resultadoExamen, fechaResultado no pueden estar vacíos",false);
        }

        if(historialExamen.getExamen()!= null){
            historialExamen.setFechaCambioEstado(new Date(System.currentTimeMillis()));
            historialExamenRepository.save(historialExamen);
        }
        if(examenEntity.getSubEstado().getSubEstadoNombre() == SubEstadoNombre.CANCELADO){
            return new Mensaje("Examen cancelado exitosamente",true);
        }
        return new Mensaje("Se actualizó de manera correcta",true);
    }

    @Override
    public Mensaje registrarResultadoExamen(Long examenId,Integer estadoResultadoExamenId, MultipartFile resultadoExamen,Date fechaResultado) {
        ExamenActDto examenActDto = new ExamenActDto();
        examenActDto.setId(examenId);
        examenActDto.setEstadoResultadoExamenId(estadoResultadoExamenId);
        examenActDto.setResultadoExamen(resultadoExamen);
        examenActDto.setFechaResultado(fechaResultado);
        Mensaje resultado = actualizarExamen(examenActDto);
        if(resultado.isExito()){
            return new Mensaje("Resultado se guardó de manera correcta",true);
        }
        return resultado;
    }


}
