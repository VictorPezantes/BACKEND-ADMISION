package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.*;
import com.pe.ttk.admision.service.DatoAdicionalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/datoadicional")
public class DatoAdicionalController {
    @Autowired
    DatoAdicionalService datoAdicionalService;

    @ApiOperation("Listar los datos académicos de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/academico/listar")
    public ResponseEntity<?> listar(@RequestParam(defaultValue = "0") Integer numPagina,
                                           @RequestParam(defaultValue = "10") Integer tamPagina,
                                           @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoAcademico(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato académico de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/academico/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoAcademico(datoAcademicoDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato académico")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/academico/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoAcademico(datoAcademicoDto), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Listar los datos bancarios de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/bancario/listar")
    public ResponseEntity<?> listarDatoBancario(@RequestParam(defaultValue = "0") Integer numPagina,
                                                      @RequestParam(defaultValue = "10") Integer tamPagina,
                                                      @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoBancario(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato bancario de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/bancario/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoBancarioDto datoBancarioDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoBancario(datoBancarioDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato bancario")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/bancario/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoBancarioDto datoBancarioDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoBancario(datoBancarioDto), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Listar los datos contacto de emergencia de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/contactoemergencia/listar")
    public ResponseEntity<?> listarContactoEmergencia(@RequestParam(defaultValue = "0") Integer numPagina,
                                           @RequestParam(defaultValue = "10") Integer tamPagina,
                                           @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoContactoEmergencia(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato de contacto de emergencia de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/contactoemergencia/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoContactoEmergenciaDto datoContactoEmergenciaDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoContactoEmergencia(datoContactoEmergenciaDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato de contacto de emergencia")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/contactoemergencia/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoContactoEmergenciaDto datoContactoEmergenciaDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoContactoEmergencia(datoContactoEmergenciaDto), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Listar los datos laborales de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/laboral/listar")
    public ResponseEntity<?> listarLaboral(@RequestParam(defaultValue = "0") Integer numPagina,
                                                      @RequestParam(defaultValue = "10") Integer tamPagina,
                                                      @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoLaboral(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato laboral de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/laboral/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoLaboralDto datoLaboralDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoLaboral(datoLaboralDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato laboral")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/laboral/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoLaboralDto datoLaboralDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoLaboral(datoLaboralDto), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Listar los datos de embarque de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/embarque/listar")
    public ResponseEntity<?> listarEmbarque(@RequestParam(defaultValue = "0") Integer numPagina,
                                           @RequestParam(defaultValue = "10") Integer tamPagina,
                                           @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoEmbarque(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato de embarque de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/embarque/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoEmbarqueDto datoEmbarqueDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoEmbarque(datoEmbarqueDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato de embarque")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/embarque/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoEmbarqueDto datoEmbarqueDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoEmbarque(datoEmbarqueDto), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Listar los datos de red social de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/redsocial/listar")
    public ResponseEntity<?> listarRedSocial(@RequestParam(defaultValue = "0") Integer numPagina,
                                            @RequestParam(defaultValue = "10") Integer tamPagina,
                                            @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoRedSocial(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato de red social de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/redsocial/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoRedSocialDto datoRedSocialDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoRedSocial(datoRedSocialDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato de red social")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/redsocial/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoRedSocialDto datoRedSocialDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoRedSocial(datoRedSocialDto), HttpStatus.ACCEPTED);
    }
}
