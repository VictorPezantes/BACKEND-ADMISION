package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
@Getter
@Setter
public class ExamenActDto {

    @NotNull
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Lima")
    private Date fechaProgramada;
    @Null
    private Integer centroMedicoId;
    @Null
    private Integer subEstadoId;
    @Null
    private Integer resultadoExamenId;
}
