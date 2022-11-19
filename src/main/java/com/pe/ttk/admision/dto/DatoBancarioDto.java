package com.pe.ttk.admision.dto;

import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
