package com.pe.ttk.admision.repository.security;

import java.util.Optional;

import com.pe.ttk.admision.entity.security.Rol;
import com.pe.ttk.admision.enums.security.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	Optional<Rol>findByRolNombre(RolNombre rolNombre);

}
