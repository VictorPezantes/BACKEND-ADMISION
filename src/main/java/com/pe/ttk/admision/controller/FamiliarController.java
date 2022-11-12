package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.FamiliarDto;
import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.service.FamiliarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/familiar")
public class FamiliarController {
    @Autowired
    FamiliarService familiarService;

    @ApiOperation("Listar los familiares de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<?> listarOfertas(@RequestParam(defaultValue = "0") Integer numPagina,
                                           @RequestParam(defaultValue = "10") Integer tamPagina,
                                           @RequestParam Long postulanteId) {

        return ResponseEntity.ok(familiarService.listar(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un familiar de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody FamiliarDto familiarDto) {
        return new ResponseEntity(familiarService.registrar(familiarDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un familiar")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarPostulante(@RequestBody FamiliarDto familiarDto) {
        return new ResponseEntity(familiarService.actualizar(familiarDto), HttpStatus.ACCEPTED);
    }
}
