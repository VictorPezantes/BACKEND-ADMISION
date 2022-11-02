package com.pe.ttk.admision.controller.config;

import com.pe.ttk.admision.service.ArchivoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/archivo")
public class ArchivoController {

    @Autowired
    ArchivoService archivoService;

    @ApiOperation("obtenerImagen")
    @GetMapping("/obtenerFotoPostulante")
    public ResponseEntity<?> registrarUsuario(@RequestParam Long postulanteId)
    {

        return ResponseEntity.status(HttpStatus.OK).body(archivoService.obtenerFotoPostulante(postulanteId));
    }
}
