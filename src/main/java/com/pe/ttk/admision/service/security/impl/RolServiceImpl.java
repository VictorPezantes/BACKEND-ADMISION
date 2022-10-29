package com.pe.ttk.admision.service.security.impl;

import java.util.Optional;

import com.pe.ttk.admision.entity.security.Rol;
import com.pe.ttk.admision.enums.security.RolNombre;
import com.pe.ttk.admision.repositoy.security.RolRepository;
import com.pe.ttk.admision.service.security.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolServiceImpl implements RolService {
	
	@Autowired
    RolRepository rolRepository;

	@Override
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		
		return rolRepository.findByRolNombre(rolNombre);	
	}

	@Override
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
	
	

}
