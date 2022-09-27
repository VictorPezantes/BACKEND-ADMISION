package com.pe.ttk.admision.security.entity;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.pe.ttk.admision.security.dto.UsuarioDto;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@Column(unique = true)
	private String nombreUsuario;
	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private String password;
	private String tokenPassword;
	private int estado;

	private String fotografia;
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String apellidos, @NotNull String email,
			@NotNull String password,String fotografia, int estado) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.estado = estado;
	}

	public Usuario() {
		
	}//public UsuarioDto usuarioDto() throws ClassCastException{
		//return new JsonMapper<>(UsuarioDto.class, Usuario.class)
				//.getDestination(this);
	}

//}
