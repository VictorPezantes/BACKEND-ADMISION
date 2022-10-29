package com.pe.ttk.admision.controller.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.security.JwtDto;
import com.pe.ttk.admision.dto.security.LoginUsuario;
import com.pe.ttk.admision.dto.security.NuevoUsuario;
import com.pe.ttk.admision.dto.security.UsuarioDto;
import com.pe.ttk.admision.entity.security.UsuarioPrincipal;
import com.pe.ttk.admision.security.jwt.JwtProvider;
import com.pe.ttk.admision.service.security.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    JwtProvider jwtProvider;

    @ApiOperation("Registrar un usuario final")
    @PostMapping("/registrar-usuario")
    public ResponseEntity<?> registrarUsuario(@RequestParam(name = "foto", required = false)
                                              MultipartFile foto,
                                              @RequestParam String nombre,
                                                  @RequestParam String apellidos,
                                                  @RequestParam String email,
                                                  @RequestParam String password,
                                                  @RequestParam String nombreUsuario,
                                                  @RequestParam String fotografia,
                                                 @RequestParam Set<String> roles) throws JsonProcessingException {
        NuevoUsuario nuevoUsuario = new NuevoUsuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setFotografia(fotografia);
        nuevoUsuario.setRoles(roles);

        /*if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(new Mensaje("Por favor ingrese los campos correctamente"));*/

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarUsuario(nuevoUsuario, false, foto));
    }

    @ApiOperation("Registrar un usuario administrador")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar-admin")
    public ResponseEntity<?> registrarUsuarioAdmin(@RequestParam(name = "foto", required = false)
                                                       MultipartFile foto,
                                                   @RequestParam String nombre,
                                                   @RequestParam String apellidos,
                                                   @RequestParam String email,
                                                   @RequestParam String password,
                                                   @RequestParam String nombreUsuario,
                                                   @RequestParam String fotografia) throws JsonProcessingException {

        NuevoUsuario nuevoUsuario = new NuevoUsuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setFotografia(fotografia);

        /*if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(new Mensaje("Por favor ingrese los campos correctamente"));*/

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarUsuario(nuevoUsuario, true, foto));
    }

    @ApiOperation("Login del sistema")
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(new Mensaje("campos mal puestos",false));
        }
        if(!usuarioService.existeEmailUsuarioActivo(loginUsuario.getEmail())){
            return ResponseEntity.badRequest().body(new Mensaje("El correo electronico o usuario no existe",false));
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, usuarioPrincipal.getUsername(), usuarioPrincipal.getEmail(), usuarioPrincipal.getAuthorities());
        return ResponseEntity.ok(jwtDto);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return ResponseEntity.ok(jwt);
    }

    @ApiOperation("Obtener el usuario logueado")
    @GetMapping("/usuario-logueado")
    public ResponseEntity<?> obtenerUsuarioLogueado(Authentication auth) {
        UsuarioDto usuarioDto = usuarioService.obtenerUsuarioLogueado(auth);
        if(usuarioDto != null){
            return ResponseEntity.ok(usuarioDto);
        }
        return ResponseEntity.notFound().build();
    }


    @ApiOperation("Lista de los usuarios activos")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar-usuarios-activos")
    public ResponseEntity<?> listarUsuarios() {

        return ResponseEntity.ok(usuarioService.listarUsuariosActivos());
    }

    @ApiOperation("Eliminar un usuario por id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar-usuario")
    public ResponseEntity<?> eliminarUsuario(@RequestBody UsuarioDto usuario) {

        usuarioService.eliminarUsuario(usuario.getId());
        return ResponseEntity.ok(new Mensaje("Usuario eliminado",true));
    }
}

