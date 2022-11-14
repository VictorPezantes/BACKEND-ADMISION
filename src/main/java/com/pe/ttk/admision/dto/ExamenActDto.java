package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
@Getter
@Setter
public class ExamenActDto {

    @NotNull
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaProgramada;
    @Null
    private Integer subEstadoId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Null
    private Date fechaInformeMedico;
    @Null
    private Integer tipoExamenId;
    @Null
    private String observaciones;
    @Null
    private Integer centroMedicoId;
    @Null
    private Integer EstadoResultadoExamenId;
    @Null
    private String autorizoGerencia;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Null
    private Date fechaCambioEstado;
    @Null
    private MultipartFile resultadoExamen;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Null
    private Date fechaResultado;
    @Null
    private Boolean solicitudPostulante;
}
