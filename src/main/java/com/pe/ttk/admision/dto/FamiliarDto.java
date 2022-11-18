package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pe.ttk.admision.entity.master.Departamento;
import com.pe.ttk.admision.entity.master.Distrito;
import com.pe.ttk.admision.entity.master.Parentesco;
import com.pe.ttk.admision.entity.master.Provincia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamiliarDto {
    private Long id;
    @NotNull
    private String primerApellido;
    private String segundoApellido;
    @NotNull
    private String primerNombre;
    private String segundoNombre;
    @NotNull
    private String dni;
    private Date fechaNacimiento;
    private Date lugarNacimiento;
    private String ocupacion;
    private String direccion;
    private Long distritoId;
    private String distritoNombre;
    private Long provinciaId;
    private String provinciaNombre;
    private Long departamentoId;
    private String departamentoNombre;
    @NotNull
    private Integer parentescoId;
    @NotNull
    private Long postulanteId;
    private String postulanteNombre;
}
