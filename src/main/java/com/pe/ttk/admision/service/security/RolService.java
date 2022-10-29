package com.pe.ttk.admision.service.security;

import com.pe.ttk.admision.entity.security.Rol;
import com.pe.ttk.admision.enums.security.RolNombre;

import java.util.Optional;

public interface RolService {

    Optional<Rol> getByRolNombre(RolNombre rolNombre);

    void save(Rol rol);

}
