package com.pe.ttk.admision.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pe.ttk.admision.dto.ExamenActDto;
import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.service.impl.ExamenServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/examen")
public class ExamenController {
    @Autowired
    ExamenServiceImpl examenService;

    @ApiOperation("Registrar examen")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody @Valid ExamenDto examen){
        examen.setFecha(new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(examenService.registrarExamen(examen));
    }
    @ApiOperation("actualizar datos de un examen")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody @Valid ExamenActDto examen){
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }
    @ApiOperation("registra el resultado de un examen")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrarResultado")
    public ResponseEntity<?> cancelar(
            @RequestParam Long examenId,
            @RequestParam Integer estadoResultadoExamenId,
            @RequestParam MultipartFile resultadoExamen,
            @RequestParam(required = false) @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima") Date fechaResultado,
            @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima") Date fechaInformeMedico){
        return ResponseEntity.ok(examenService.registrarResultadoExamen(examenId,estadoResultadoExamenId,resultadoExamen,fechaResultado,fechaInformeMedico));
    }
}
