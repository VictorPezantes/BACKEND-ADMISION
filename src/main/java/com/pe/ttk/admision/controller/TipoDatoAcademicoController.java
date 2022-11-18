package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.service.TipoDatoAcademicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tipodatoacademico")
public class TipoDatoAcademicoController {
    @Autowired
    TipoDatoAcademicoService tipoDatoAcademicoService;
    @ApiOperation("Lista todos tipos de datos academicos")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {

        return ResponseEntity.ok(tipoDatoAcademicoService.listar());
    }
}
