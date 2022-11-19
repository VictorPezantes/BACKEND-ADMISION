package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.dto.DatoBancarioDto;
import com.pe.ttk.admision.dto.DatoContactoEmergenciaDto;
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
    @GetMapping("/datoacademico/listar")
    public ResponseEntity<?> listar(@RequestParam(defaultValue = "0") Integer numPagina,
                                           @RequestParam(defaultValue = "10") Integer tamPagina,
                                           @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoAcademico(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato académico de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/datoacademico/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoAcademico(datoAcademicoDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato académico")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/datoacademico/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoAcademico(datoAcademicoDto), HttpStatus.ACCEPTED);
    }
    @ApiOperation("Listar los datos contacto de emergencia de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/datobancario/listar")
    public ResponseEntity<?> listarDatoBancario(@RequestParam(defaultValue = "0") Integer numPagina,
                                                      @RequestParam(defaultValue = "10") Integer tamPagina,
                                                      @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoBancario(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato académico de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/datobancario/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoBancarioDto datoBancarioDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoBancario(datoBancarioDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato académico")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/datobancario/actualizar")
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

    @ApiOperation("registra un dato académico de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/contactoemergencia/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoContactoEmergenciaDto datoContactoEmergenciaDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoContactoEmergencia(datoContactoEmergenciaDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato académico")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/contactoemergencia/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody DatoContactoEmergenciaDto datoContactoEmergenciaDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoContactoEmergencia(datoContactoEmergenciaDto), HttpStatus.ACCEPTED);
    }
}
