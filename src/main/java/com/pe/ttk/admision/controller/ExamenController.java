package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.ExamenDto;
import com.pe.ttk.admision.service.impl.ExamenServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/examen")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamenController {
    @Autowired
    ExamenServiceImpl examenService;

    @ApiOperation("Registrar examen")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody ExamenDto examen){
        examen.setFecha(new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(examenService.registrarExamen(examen));
    }
}
