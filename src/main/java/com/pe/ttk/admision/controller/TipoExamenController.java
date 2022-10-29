package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.service.CentroMedicoService;
import com.pe.ttk.admision.service.TipoExamenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tipoexamen")
public class TipoExamenController {
    @Autowired
    TipoExamenService tipoExamenService;
    @ApiOperation("Lista todos los centros médicos")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {

        return ResponseEntity.ok(tipoExamenService.listar());
    }
}
