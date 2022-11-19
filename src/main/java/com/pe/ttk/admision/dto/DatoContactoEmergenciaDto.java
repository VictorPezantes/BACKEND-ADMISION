package com.pe.ttk.admision.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatoContactoEmergenciaDto {
    private Long id;
    private Long postulanteId;
    private Integer parentescoId;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String celular;
    private String telefono;
    private String email;
}
