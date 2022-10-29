package com.pe.ttk.admision.service.security;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.security.NuevoUsuario;
import com.pe.ttk.admision.dto.security.UsuarioDto;
import com.pe.ttk.admision.entity.security.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> getByNombreUsuario(String nombreUsuario);

    Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEmail);

    List<Usuario> listarUsuarios();

    boolean existsByNombreUsuario(String nombreUsuario);

    boolean existsByEmail(String email);

    void eliminarUsuario(int id);

    void save(Usuario usuario);

    Optional<Usuario> getByTokenPassword(String tokenPassword);

    List<UsuarioDto> listarUsuariosActivos();

    UsuarioDto obtenerUsuarioLogueado(Authentication auth);

    boolean existeEmailUsuarioActivo(String email);

    boolean existeEmailActivo(String email);

    boolean existeNombreUsuarioActivo(String nombreUsuario);

    Mensaje registrarUsuario(NuevoUsuario nuevoUsuario, boolean isAdmin, MultipartFile foto);

}
