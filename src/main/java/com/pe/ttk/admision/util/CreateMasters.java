package com.pe.ttk.admision.util;

import com.pe.ttk.admision.entity.master.*;
import com.pe.ttk.admision.enums.*;
import com.pe.ttk.admision.entity.security.Rol;
import com.pe.ttk.admision.enums.security.RolNombre;
import com.pe.ttk.admision.service.*;
import com.pe.ttk.admision.service.security.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateMasters implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
    TipoExamenService tipoExamenService;

    @Autowired
    SubEstadoService subEstadoService;

    @Autowired
    ResultadoExamenService resultadoExamenService;

    @Autowired
    CentroMedicoService centroMedicoService;

    @Autowired
    EstadoPostulanteService estadoPostulanteService;

    @Autowired
    EstadoOfertaService estadoOfertaService;

    @Override
    public void run(String... args) throws Exception {

        //Rol
        Optional<Rol> rolAdm = rolService.getByRolNombre(RolNombre.ROLE_ADMIN);
        if(rolAdm.isEmpty()){
            Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
            rolService.save(rolAdmin);
        }
        Optional<Rol> rolUs = rolService.getByRolNombre(RolNombre.ROLE_USER);
        if(rolUs.isEmpty()){
            Rol rolUser = new Rol(RolNombre.ROLE_USER);
            rolService.save(rolUser);
        }
        //TipoExamen
        Optional<TipoExamenNombre> tipoExamenGen = tipoExamenService.findByTipoExamenNombre(TipoExamenNombre.GENERAL);
        if(tipoExamenGen.isEmpty()){
            TipoExamen tipoExamenGeneral = new TipoExamen(TipoExamenNombre.GENERAL);
            tipoExamenService.save(tipoExamenGeneral);
        }
        //SubEstado
        Optional<SubEstadoNombre> subEstadoNombreProgramado = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.PROGRAMADO);
        if (subEstadoNombreProgramado.isEmpty()){
            SubEstado subEstadoProgramado = new SubEstado(SubEstadoNombre.PROGRAMADO);
            subEstadoService.save(subEstadoProgramado);
        }
        Optional<SubEstadoNombre> subEstadoNombreAprobado = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.APROBADO);
        if (subEstadoNombreAprobado.isEmpty()){
            SubEstado subEstadoAprobado = new SubEstado(SubEstadoNombre.APROBADO);
            subEstadoService.save(subEstadoAprobado);
        }
        Optional<SubEstadoNombre> subEstadoNombreCancelado = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.CANCELADO);
        if (subEstadoNombreCancelado.isEmpty()){
            SubEstado subEstadoCancelado = new SubEstado(SubEstadoNombre.CANCELADO);
            subEstadoService.save(subEstadoCancelado);
        }
        Optional<SubEstadoNombre> subEstadoNombreDesaprobado = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.DESAPROBADO);
        if (subEstadoNombreDesaprobado.isEmpty()){
            SubEstado subEstadoDesaprobado = new SubEstado(SubEstadoNombre.DESAPROBADO);
            subEstadoService.save(subEstadoDesaprobado);
        }
        Optional<SubEstadoNombre> subEstadoNombreObservado = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.OBSERVADO);
        if (subEstadoNombreObservado.isEmpty()){
            SubEstado subEstadoObservado = new SubEstado(SubEstadoNombre.OBSERVADO);
            subEstadoService.save(subEstadoObservado);
        }
        Optional<SubEstadoNombre> subEstadoNombreReprogramado = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.REPROGRAMADO);
        if (subEstadoNombreReprogramado.isEmpty()){
            SubEstado subEstadoReprogramado = new SubEstado(SubEstadoNombre.REPROGRAMADO);
            subEstadoService.save(subEstadoReprogramado);
        }
        //SubEstado
        Optional<SubEstadoNombre> subEstadoNombrePendiente = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.PENDIENTE);
        if (subEstadoNombrePendiente.isEmpty()){
            SubEstado subEstadoPendiente = new SubEstado(SubEstadoNombre.PENDIENTE);
            subEstadoService.save(subEstadoPendiente);
        }
        //Resultado
        Optional<EstadoResultadoExamenNombre> resultadoExamenNombreAprobado = resultadoExamenService.findByResultadoExamenNombre(EstadoResultadoExamenNombre.APROBADO);
        if (resultadoExamenNombreAprobado.isEmpty()){
            EstadoResultadoExamen estadoResultadoExamenAprobado = new EstadoResultadoExamen(EstadoResultadoExamenNombre.APROBADO);
            resultadoExamenService.save(estadoResultadoExamenAprobado);
        }
        Optional<EstadoResultadoExamenNombre> resultadoExamenNombreDesaprobado = resultadoExamenService.findByResultadoExamenNombre(EstadoResultadoExamenNombre.DESAPROBADO);
        if (resultadoExamenNombreDesaprobado.isEmpty()){
            EstadoResultadoExamen estadoResultadoExamenDesaprobado = new EstadoResultadoExamen(EstadoResultadoExamenNombre.DESAPROBADO);
            resultadoExamenService.save(estadoResultadoExamenDesaprobado);
        }
        Optional<EstadoResultadoExamenNombre> resultadoExamenNombreObservado = resultadoExamenService.findByResultadoExamenNombre(EstadoResultadoExamenNombre.OBSERVADO);
        if (resultadoExamenNombreObservado.isEmpty()){
            EstadoResultadoExamen estadoResultadoExamenObservado = new EstadoResultadoExamen(EstadoResultadoExamenNombre.OBSERVADO);
            resultadoExamenService.save(estadoResultadoExamenObservado);
        }
        Optional<CentroMedicoNombre> centroMedicoNombre = centroMedicoService.findAllByCentroMedicoNombre(CentroMedicoNombre.CENTRO_MEDICO_TEST);
        if (centroMedicoNombre.isEmpty()){
            CentroMedico centroMedico = new CentroMedico(CentroMedicoNombre.CENTRO_MEDICO_TEST);
            centroMedicoService.save(centroMedico);
        }
        //Estado postulante
        Optional<EstadoPostulanteNombre> estadoPostulanteNombreIngresado = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.INGRESADO);
        if(estadoPostulanteNombreIngresado.isEmpty()){
            EstadoPostulante estadoPostulanteIngresado = new EstadoPostulante(EstadoPostulanteNombre.INGRESADO);
            estadoPostulanteService.save(estadoPostulanteIngresado);
        }

        Optional<EstadoPostulanteNombre> estadoPostulanteNombreVerificacion = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.VERIFICACION);
        if(estadoPostulanteNombreVerificacion.isEmpty()){
            EstadoPostulante estadoPostulanteVerificacion = new EstadoPostulante(EstadoPostulanteNombre.VERIFICACION);
            estadoPostulanteService.save(estadoPostulanteVerificacion);
        }

        Optional<EstadoPostulanteNombre> estadoPostulanteNombreEntrevistaPersonal = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.ENTREVISTA_PERSONAL);
        if(estadoPostulanteNombreEntrevistaPersonal.isEmpty()){
            EstadoPostulante estadoPostulanteEntrevistaPersonal = new EstadoPostulante(EstadoPostulanteNombre.ENTREVISTA_PERSONAL);
            estadoPostulanteService.save(estadoPostulanteEntrevistaPersonal);
        }

        Optional<EstadoPostulanteNombre> estadoestadoPostulanteFueraDelProceso = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.FUERA_DEL_PROCESO);
        if(estadoestadoPostulanteFueraDelProceso.isEmpty()){
            EstadoPostulante estadoPostulanteFueraDelProceso = new EstadoPostulante(EstadoPostulanteNombre.FUERA_DEL_PROCESO);
            estadoPostulanteService.save(estadoPostulanteFueraDelProceso);
        }

        Optional<EstadoPostulanteNombre> estadoPostulanteNombreExamenMedico = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.EXAMEN_MEDICO);
        if(estadoPostulanteNombreExamenMedico.isEmpty()){
            EstadoPostulante estadoPostulanteExamenMedico = new EstadoPostulante(EstadoPostulanteNombre.EXAMEN_MEDICO);
            estadoPostulanteService.save(estadoPostulanteExamenMedico);
        }

        Optional<EstadoPostulanteNombre> estadoPostulanteNombreReferenciasPersonales = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.REFERENCIAS_PERSONALES);
        if(estadoPostulanteNombreReferenciasPersonales.isEmpty()){
            EstadoPostulante estadoPostulanteReferenciasPersonales = new EstadoPostulante(EstadoPostulanteNombre.REFERENCIAS_PERSONALES);
            estadoPostulanteService.save(estadoPostulanteReferenciasPersonales);
        }

        Optional<EstadoPostulanteNombre> estadoPostulanteNombrePoligrafia = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.POLIGRAFIA);
        if(estadoPostulanteNombrePoligrafia.isEmpty()){
            EstadoPostulante estadoPostulantePoligrafia = new EstadoPostulante(EstadoPostulanteNombre.POLIGRAFIA);
            estadoPostulanteService.save(estadoPostulantePoligrafia);
        }

        Optional<EstadoPostulanteNombre> estadoPostulanteNombreEvaluacion = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.EVALUACION);
        if(estadoPostulanteNombreEvaluacion.isEmpty()){
            EstadoPostulante estadoPostulanteEvaluacion = new EstadoPostulante(EstadoPostulanteNombre.EVALUACION);
            estadoPostulanteService.save(estadoPostulanteEvaluacion);
        }

        Optional<EstadoPostulanteNombre> estadoPostulanteNombreAltaEmpresa = estadoPostulanteService.findAllByEstadoPostulanteNombre(EstadoPostulanteNombre.ALTA_EMPRESA);
        if(estadoPostulanteNombreAltaEmpresa.isEmpty()){
            EstadoPostulante estadoPostulanteAltaEmpresa = new EstadoPostulante(EstadoPostulanteNombre.ALTA_EMPRESA);
            estadoPostulanteService.save(estadoPostulanteAltaEmpresa);
        }

        //estado oferta
        Optional<EstadoOfertaNombre> estadoOfertaNombreCreado = estadoOfertaService.findAllByEstadoOfertaNombre(EstadoOfertaNombre.CREADO);
        if(estadoOfertaNombreCreado.isEmpty()){
            EstadoOferta estadoOfertaCreado = new EstadoOferta(EstadoOfertaNombre.CREADO);
            estadoOfertaService.save(estadoOfertaCreado);
        }

        Optional<EstadoOfertaNombre> estadoOfertaNombreActivado = estadoOfertaService.findAllByEstadoOfertaNombre(EstadoOfertaNombre.ACTIVADO);
        if(estadoOfertaNombreActivado.isEmpty()){
            EstadoOferta estadoOfertaActivado = new EstadoOferta(EstadoOfertaNombre.ACTIVADO);
            estadoOfertaService.save(estadoOfertaActivado);
        }

        Optional<EstadoOfertaNombre> estadoOfertaNombreDesactivado = estadoOfertaService.findAllByEstadoOfertaNombre(EstadoOfertaNombre.DESACTIVADO);
        if(estadoOfertaNombreDesactivado.isEmpty()){
            EstadoOferta estadoOfertaDesactivado = new EstadoOferta(EstadoOfertaNombre.DESACTIVADO);
            estadoOfertaService.save(estadoOfertaDesactivado);
        }

    }
}
