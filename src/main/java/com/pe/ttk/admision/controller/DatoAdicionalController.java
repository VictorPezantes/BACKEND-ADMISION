package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.DatoAcademicoDto;
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
    @GetMapping("/listar-datoacademico")
    public ResponseEntity<?> listarOfertas(@RequestParam(defaultValue = "0") Integer numPagina,
                                           @RequestParam(defaultValue = "10") Integer tamPagina,
                                           @RequestParam Long postulanteId) {

        return ResponseEntity.ok(datoAdicionalService.listarDatoAcademico(numPagina, tamPagina, postulanteId));
    }

    @ApiOperation("registra un dato académico de un postulante")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar-datoacademico")
    public ResponseEntity<?> registrar(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAdicionalService.registrarDatoAcademico(datoAcademicoDto), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Actualizar distintos campos de un dato académico")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar-datoacademico")
    public ResponseEntity<?> actualizarPostulante(@RequestBody DatoAcademicoDto datoAcademicoDto) {
        return new ResponseEntity(datoAdicionalService.actualizarDatoAcademico(datoAcademicoDto), HttpStatus.ACCEPTED);
    }
}
