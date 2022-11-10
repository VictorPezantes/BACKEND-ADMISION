package com.pe.ttk.admision.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.master.EstadoOferta;
import com.pe.ttk.admision.service.impl.EstadoOfertaServiceImp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estadoOferta")
public class EstadoOfertaController {

    @Autowired
    EstadoOfertaServiceImp estadoOfertaServiceImp;

    @ApiOperation("Lista todos los estados de las ofertas")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<?> listarEstados() {

        return ResponseEntity.ok(estadoOfertaServiceImp.listaEstados());

    }

    @ApiOperation("Registrar estado")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/registrar")
    public ResponseEntity<?> registrarEstado(@RequestBody EstadoOferta estadoOferta) {

        estadoOfertaServiceImp.save(estadoOferta);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Mensaje("estado registrado correctamente",true));
    }

    @ApiOperation("Eliminar un estado por id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/eliminar", produces = "application/json")
    public ResponseEntity<?> eliminarEstado(@RequestParam("id") Integer id) {

        estadoOfertaServiceImp.eliminarEstado(id);
        return ResponseEntity.ok(new Mensaje("Estado eliminado",true));
    }

    @ApiOperation("Actualizar distintos campos de un estado")
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping(value = "/actualizar/{id}", produces = "application/json")
    public ResponseEntity<?> actualizarEstado(@PathVariable("id") Integer id, @RequestBody EstadoOferta estadoOferta) {

        estadoOfertaServiceImp.actualizarEstado(id, estadoOferta);
        return ResponseEntity.accepted().body(new Mensaje("estado actualizado",true));
    }
}












