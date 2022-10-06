package com.pe.ttk.admision.dto.entity.master;

import com.pe.ttk.admision.enums.ResultadoExamenNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class ResultadoExamen{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ResultadoExamenNombre resultadoExamenNombre;
    private Integer estado;
}
