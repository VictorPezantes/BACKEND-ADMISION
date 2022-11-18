package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatoAcademicoDto {
    private Long id;
    private Long postulanteId;
    private Integer tipoDatoAcademicoId;
    private String tipoDatoAcademicoNombre;
    private Integer nivelEstudioId;
    private String nivelEstudioNombre;
    private String centroEducativo;
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
}
