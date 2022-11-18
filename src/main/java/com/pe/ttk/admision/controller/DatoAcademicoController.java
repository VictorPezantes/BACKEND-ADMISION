package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
import com.pe.ttk.admision.service.DatoAcademicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/datoacademico")
public class DatoAcademicoController {
    @Autowired
    DatoAcademicoService datoAcademicoService;

    @ApiOperation("Listar los datos académicos de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<?> listarOfertas(@RequestParam(defaultValue = "0") Integer numPagina,
                                           @RequestParam(defaultValue = "10") Integer tamPagina,
                                           @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAcademicoService.listar(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato académico de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAcademicoService.registrar(datoAcademicoDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato académico")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarPostulante(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAcademicoService.actualizar(datoAcademicoDto), HttpStatus.ACCEPTED);
    }
}
