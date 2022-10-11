package com.pe.ttk.admision.util;

import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.CentroMedicoNombre;
import com.pe.ttk.admision.enums.ResultadoExamenNombre;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import com.pe.ttk.admision.security.entity.Rol;
import com.pe.ttk.admision.security.enums.RolNombre;
import com.pe.ttk.admision.security.service.RolService;
import com.pe.ttk.admision.service.CentroMedicoService;
import com.pe.ttk.admision.service.ResultadoExamenService;
import com.pe.ttk.admision.service.SubEstadoService;
import com.pe.ttk.admision.service.TipoExamenService;
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
        Optional<SubEstadoNombre> subEstadoNombreGeneral = subEstadoService.findBySubEstadoNombre(SubEstadoNombre.PENDIENTE);
        if (subEstadoNombreGeneral.isEmpty()){
            SubEstado subEstadoGeneral = new SubEstado(SubEstadoNombre.PENDIENTE);
            subEstadoService.save(subEstadoGeneral);
        }
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
        //Resultado
        Optional<ResultadoExamenNombre> resultadoExamenNombreAprobado = resultadoExamenService.findByResultadoExamenNombre(ResultadoExamenNombre.APROBADO);
        if (resultadoExamenNombreAprobado.isEmpty()){
            EstadoResultadoExamen estadoResultadoExamenAprobado = new EstadoResultadoExamen(ResultadoExamenNombre.APROBADO);
            resultadoExamenService.save(estadoResultadoExamenAprobado);
        }
        Optional<ResultadoExamenNombre> resultadoExamenNombreDesaprobado = resultadoExamenService.findByResultadoExamenNombre(ResultadoExamenNombre.DESAPROBADO);
        if (resultadoExamenNombreDesaprobado.isEmpty()){
            EstadoResultadoExamen estadoResultadoExamenDesaprobado = new EstadoResultadoExamen(ResultadoExamenNombre.DESAPROBADO);
            resultadoExamenService.save(estadoResultadoExamenDesaprobado);
        }
        Optional<ResultadoExamenNombre> resultadoExamenNombreObservado = resultadoExamenService.findByResultadoExamenNombre(ResultadoExamenNombre.OBSERVADO);
        if (resultadoExamenNombreObservado.isEmpty()){
            EstadoResultadoExamen estadoResultadoExamenObservado = new EstadoResultadoExamen(ResultadoExamenNombre.OBSERVADO);
            resultadoExamenService.save(estadoResultadoExamenObservado);
        }
        Optional<CentroMedicoNombre> centroMedicoNombre = centroMedicoService.findAllByCentroMedicoNombre(CentroMedicoNombre.CENTRO_MEDICO_TEST);
        if (centroMedicoNombre.isEmpty()){
            CentroMedico centroMedico = new CentroMedico(CentroMedicoNombre.CENTRO_MEDICO_TEST);
            centroMedicoService.save(centroMedico);
        }
    }
}
