package com.pe.ttk.admision.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatoBancarioDto {
    private Long id;
    private Long postulanteId;
    private String moneda;
    private String banco;
    private String cuenta;
    private String cci;
    private String observacion;
    private String ruc;
    private String claveSol;
}
