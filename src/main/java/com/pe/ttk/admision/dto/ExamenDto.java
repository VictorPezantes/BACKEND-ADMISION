package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class ExamenDto {
    @Null
    private Long id;
    @Null
    private Date fecha;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Lima")
    private Date fechaInformeMedico;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Lima")
    private Date fechaProgramada;
    @Null
    private String observacion;
    @Null
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Lima")
    private Date fechaResultado;
    @NotNull
    private Integer centroMedicoId;
    @NotNull
    private Integer tipoExamenId;
    @NotNull
    private Long postulanteId;
    @Null
    private Integer subEstadoId;
    @Null
    private String urlResultadoExamen;

    public ExamenDto() {

    }
}
