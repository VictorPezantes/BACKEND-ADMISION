package com.pe.ttk.admision.util;

import com.pe.ttk.admision.dto.entity.master.TipoExamen;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import com.pe.ttk.admision.security.entity.Rol;
import com.pe.ttk.admision.security.enums.RolNombre;
import com.pe.ttk.admision.security.service.RolService;
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
    }
}
