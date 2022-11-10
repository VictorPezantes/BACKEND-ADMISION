package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.EstadoOferta;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfertaDto {

    private Long id;
    private EstadoOferta estadoOferta;
    private String titulo;
    private String descripcion;
    private String requisito;
    private Encargado creadorOferta;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaCreacion;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaPublicacion;
    private Cargo cargoOferta;
    private int cantidadPostulantes;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaActualizacion;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaDesactivado;
    private Integer estado;
}
