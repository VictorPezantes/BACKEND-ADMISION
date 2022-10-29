package com.pe.ttk.admision.controller.config;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.security.ChangePasswordDto;
import com.pe.ttk.admision.dto.security.EmailValuesDto;
import com.pe.ttk.admision.entity.security.Usuario;
import com.pe.ttk.admision.service.security.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.ttk.admision.service.security.impl.EmailServiceImpl;

@RestController
@RequestMapping("/api/v1/email-service")
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {

	@Autowired
	EmailServiceImpl emailServiceImpl;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsuarioService usuarioService;

	@Value("${spring.mail.username}")
	private String mailFrom;

	@PostMapping("/enviar-cambio-password")
	public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDto dto) {

		Optional<Usuario> usuarioOpt = usuarioService.getByNombreUsuarioOrEmail(dto.getMailTo());
		if (usuarioOpt.isEmpty())
			return ResponseEntity.badRequest().body(new Mensaje("No existe ningún usuario con esas credenciales",false));

		Usuario usuario = usuarioOpt.get();

		dto.setMailFrom(mailFrom);
		dto.setMailTo(usuario.getEmail());
		dto.setSubject("Cambio de Contraseña");
		dto.setUserName(usuario.getNombre());
		UUID uuid = UUID.randomUUID();
		String tokenPassword = uuid.toString();
		dto.setToken(tokenPassword);
		usuario.setTokenPassword(tokenPassword);
		usuarioService.save(usuario);
		emailServiceImpl.sendMailTemplate(dto);
		return ResponseEntity.ok(new Mensaje("correo para recuperar contraseña enviado correctamente",true));
	}

	@PostMapping("/cambiar-password")
	public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDto dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return ResponseEntity.badRequest().body(new Mensaje("Campos mal ingresados",false));

		if (!dto.getPassword().equals(dto.getConfirmPassword()))
			return ResponseEntity.badRequest().body(new Mensaje("Las Contraseñas no coinciden",false));

		Optional<Usuario> usuarioOpt = usuarioService.getByTokenPassword(dto.getTokenPassword());
		if (usuarioOpt.isEmpty())
			return ResponseEntity.badRequest().body(new Mensaje("No existe usuario para recuperar contraseña",false));

		Usuario usuario = usuarioOpt.get();

		String newPassword = passwordEncoder.encode(dto.getPassword());
		usuario.setPassword(newPassword);
		usuario.setTokenPassword(null);
		usuarioService.save(usuario);

		return ResponseEntity.ok(new Mensaje("Contraseña actualizada correctamente",false));

	}

}
