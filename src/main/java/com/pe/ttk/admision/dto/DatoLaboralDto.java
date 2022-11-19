package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatoLaboralDto {
    private Long id;
    private Long postulanteId;
    private String trabajo;
    private String puesto;
    private String empresa;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaInicio;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaTermino;
    private String direccion;
    private Long distritoId;
    private String distritoNombre;
    private Long provinciaId;
    private String provinciaNombre;
    private Long departamentoId;
    private String departamentoNombre;
    private String funciones;
}
