package com.pe.ttk.admision.dto.entity.master;

import com.pe.ttk.admision.enums.SubEstadoNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class SubEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private SubEstadoNombre subEstadoNombre;
    private Integer estado;
}
