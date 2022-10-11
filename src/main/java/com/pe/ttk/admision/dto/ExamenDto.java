package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Lima")
    private Date fechaProgramada;
    private String observacion;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Lima")
    private Date fechaResultado;
    private Integer centroMedicoId;
    private Integer tipoExamenId;
    private Long postulanteId;
    private Integer subEstadoId;
    @Null
    private String urlResultadoExamen;

    public ExamenDto() {

    }
}
