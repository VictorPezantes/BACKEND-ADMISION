package com.pe.ttk.admision.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.service.PostulanteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/postulante")
public class PostulanteController {

    @Autowired
    PostulanteService postulanteService;

    @ApiOperation("Lista todos los postulantes")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<?> listarPostulantes(@RequestParam(defaultValue = "0") Integer numPagina,
                                               @RequestParam(defaultValue = "10") Integer tamPagina) {
        return ResponseEntity.ok(postulanteService.listarPostulantes(numPagina, tamPagina));
    }
    @ApiOperation("Lista todos los postulantes con diferentes filtros")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listarFiltro")
    public ResponseEntity<?> listarPostulanteFiltro(@RequestParam(defaultValue = "0") Integer numPagina,
                                                    @RequestParam(defaultValue = "10") Integer tamPagina,
                                                    @RequestParam(required = false) Integer estadoPostulanteId,
                                                    @RequestParam(required = false) Integer subEstadoExamen,
                                                    @RequestParam(required = false) Date fechaInformeMedico,
                                                    @RequestParam(required = false) Date fechaProgramada,
                                                    @RequestParam(required = false) String filtro,
                                                    @RequestParam(required = false) Long encargadoId,
                                                    @RequestParam(required = false) Long cargoId) {
        try {
            return ResponseEntity.ok(postulanteService.listarPostulanteFiltro(numPagina, tamPagina, estadoPostulanteId,subEstadoExamen,fechaInformeMedico,fechaProgramada,filtro,encargadoId,cargoId));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e);
        }
    }

    @ApiOperation("Registrar un nuevo postulante")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarPostulante(@RequestParam(name = "curriculum") MultipartFile curriculum,
                                                 @RequestParam(name = "dniFrontal", required = false) MultipartFile dniFrontal,
                                                 @RequestParam(name = "dniPosterior", required = false) MultipartFile dniPosterior,
                                                 @RequestParam(name = "foto", required = false) MultipartFile foto,
                                                 @RequestParam(name = "primerNombre") String primerNombre,
                                                 @RequestParam(name = "segundoNombre", required = false) String segundoNombre,
                                                 @RequestParam(name = "apellidoPaterno") String apellidoPaterno,
                                                 @RequestParam(name = "apellidoMaterno", required = false) String apellidoMaterno,
                                                 @RequestParam(name = "idEstadoCivil") Long idEstadoCivil,
                                                 @RequestParam(name = "dni") String dni,
                                                 @RequestParam(name = "fechaNacimiento") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaNacimiento,
                                                 @RequestParam(name = "direccion") String direccion,
                                                 @RequestParam(name = "idDistrito") Long idDistrito,
                                                 @RequestParam(name = "idProvincia") Long idProvincia,
                                                 @RequestParam(name = "idDepartamento") Long idDepartamento,
                                                 @RequestParam(name = "celular") String celular,
                                                 @RequestParam(name = "celularFamiliar", required = false) String celularFamiliar,
                                                 @RequestParam(name = "telefonoFijo", required = false) String telefonoFijo,
                                                 @RequestParam(name = "email") String email,
                                                 @RequestParam(name = "emailSecundario", required = false) String emailSecundario,
                                                 @RequestParam(name = "profesion", required = false) String profesion,
                                                 @RequestParam(name = "lugarEstudios", required = false) String lugarEstudios,
                                                 @RequestParam(name = "ultimoCursoRealizado", required = false) String ultimoCursoRealizado,
                                                 @RequestParam(name = "empresaCurso", required = false) String empresaCurso,
                                                 @RequestParam(name = "trabajoReciente", required = false) String trabajoReciente,
                                                 @RequestParam(name = "fechaIngresoTrabajoReciente", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaIngresoTrabajoReciente,
                                                 @RequestParam(name = "fechaSalidaTrabajoReciente", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaSalidaTrabajoReciente,
                                                 @RequestParam(name = "empresaTrabajoReciente", required = false) String empresaTrabajoReciente,
                                                 @RequestParam(name = "motivoSalidaTrabajoReciente", required = false) String motivoSalidaTrabajoReciente,
                                                 @RequestParam(name = "disponibilidadViajar") Integer disponibilidadViajar,
                                                 @RequestParam(name = "experienciaRubro") Integer experienciaRubro,
                                                 @RequestParam(name = "estadoPostulanteId", required = false) Integer estadoPostulanteId,
                                                 @RequestParam(name = "procedencia", required = false) String procedencia,
                                                 @RequestParam(name = "idOferta", required = false) Long idOferta,
                                                 @RequestParam(name = "ofertaPostulada", required = false) String ofertaPostulada,
                                                 @RequestParam(name = "urlCurriculumVitae", required = false) String urlCurriculumVitae,
                                                 @RequestParam(name = "urlDniFrontal", required = false) String urlDniFrontal,
                                                 @RequestParam(name = "urlDniPosterior", required = false) String urlDniPosterior,
                                                 @RequestParam(name = "urlFotografia", required = false) String urlFotografia) throws JsonProcessingException {
        PostulanteDto postulanteDto = new PostulanteDto();
        postulanteDto.setPrimerNombre(primerNombre);
        postulanteDto.setSegundoNombre(segundoNombre);
        postulanteDto.setApellidoPaterno(apellidoPaterno);
        postulanteDto.setApellidoMaterno(apellidoMaterno);
        postulanteDto.setIdEstadoCivil(idEstadoCivil);
        postulanteDto.setDni(dni);
        postulanteDto.setFechaNacimiento(fechaNacimiento);
        postulanteDto.setDireccion(direccion);
        postulanteDto.setIdDistrito(idDistrito);
        postulanteDto.setIdProvincia(idProvincia);
        postulanteDto.setIdDepartamento(idDepartamento);
        postulanteDto.setCelular(celular);
        postulanteDto.setCelularFamiliar(celularFamiliar);
        postulanteDto.setTelefonoFijo(telefonoFijo);
        postulanteDto.setEmail(email);
        postulanteDto.setEmailSecundario(emailSecundario);
        postulanteDto.setProfesion(profesion);
        postulanteDto.setLugarEstudios(lugarEstudios);
        postulanteDto.setUltimoCursoRealizado(ultimoCursoRealizado);
        postulanteDto.setEmpresaCurso(empresaCurso);
        postulanteDto.setTrabajoReciente(trabajoReciente);
        postulanteDto.setFechaIngresoTrabajoReciente(fechaIngresoTrabajoReciente);
        postulanteDto.setFechaSalidaTrabajoReciente(fechaSalidaTrabajoReciente);
        postulanteDto.setEmpresaTrabajoReciente(empresaTrabajoReciente);
        postulanteDto.setMotivoSalidaTrabajoReciente(motivoSalidaTrabajoReciente);
        postulanteDto.setDisponibilidadViajar(disponibilidadViajar);
        postulanteDto.setExperienciaRubro(experienciaRubro);
        postulanteDto.setEstadoPostulanteId(estadoPostulanteId);
        postulanteDto.setFechaPostulacion(new Date(System.currentTimeMillis()));
        postulanteDto.setProcedencia(procedencia);
        postulanteDto.setIdOferta(idOferta);
        postulanteDto.setOfertaPostulada(ofertaPostulada);
        postulanteDto.setUrlCurriculumVitae(urlCurriculumVitae);
        postulanteDto.setUrlDniFrontal(urlDniFrontal);
        postulanteDto.setUrlDniPosterior(urlDniPosterior);
        postulanteDto.setUrlFotografia(urlFotografia);
        List<String> validaciones = postulanteDto.Validar();
        /*if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(new Mensaje("Por favor ingrese los campos correctamente"));*/
        try {
            if(validaciones.size() > 0){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validaciones);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(postulanteService.registrarPostulante(postulanteDto, curriculum,
                    dniFrontal, dniPosterior, foto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ApiOperation("Actualizar archivos de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar-archivos")
    public ResponseEntity<?> actualizarPostulante(@RequestParam(name = "postulanteId") Long postulanteId,
                                                  @RequestParam(name = "dnifrontal", required = false) MultipartFile dnifrontal,
                                                  @RequestParam(name = "foto", required = false) MultipartFile foto,
                                                  @RequestParam(name = "dniposterior", required = false) MultipartFile dniposterior,
                                                  @RequestParam(name = "curriculum", required = false) MultipartFile curriculum) {
        PostulanteDto postulanteDto = new PostulanteDto();
        postulanteDto.setId(postulanteId);
        postulanteService.UpdatePostulante(postulanteDto, dnifrontal, dniposterior, foto,curriculum);

        return new ResponseEntity(new Mensaje("Datos del postulante actualizados correctamente",true), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Actualizar distintos campos de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar-data")
    public ResponseEntity<?> actualizarPostulante(@RequestBody PostulanteDto postulanteDto) {
        return new ResponseEntity(postulanteService.UpdatePostulante(postulanteDto, null, null, null,null), HttpStatus.ACCEPTED);
    }

    @ApiOperation("obtener foto de postulante")
    @GetMapping("/obtenerFotoPostulante")
    public ResponseEntity<?> obtenerFotoPostulante(@RequestParam Long postulanteId)
    {

        return ResponseEntity.status(HttpStatus.OK).body(postulanteService.obtenerFotoPostulanteBase64(postulanteId));
    }
    @ApiOperation("obtener CV de postulante")
    @GetMapping("/obtenerCVPostulante")
    public ResponseEntity<?> obtenerCurriculumPostulante(@RequestParam(name = "id") String postulanteId)
    {
        Long postulanteIdL = Long.parseLong(postulanteId);
        return ResponseEntity.status(HttpStatus.OK).body(postulanteService.obtenerCurriculumPostulanteBase64(postulanteIdL));
    }
    @ApiOperation("enviar cv a varios correos de postulante")
    @PostMapping("/enviarCVPorCorreo")
    public ResponseEntity<?> enviarCVPorCorreo(@RequestParam Long postulanteId,@RequestParam List<String> correos)
    {
        return ResponseEntity.status(HttpStatus.OK).body(postulanteService.enviarCVPorCorreo(postulanteId,correos));
    }

}
