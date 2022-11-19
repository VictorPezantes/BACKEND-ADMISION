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
public class DatoEmbarqueDto {
    private Long id;
    private Long postulanteId;
    private String numeroEmbarque;
    private String buqueEmbarque;
    private String tecnicoACargo;
    private String trabajoARealizar;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaEmbarque;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaDesembarque;
}
