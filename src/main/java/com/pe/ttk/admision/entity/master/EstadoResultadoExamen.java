package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.EstadoResultadoExamenNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class EstadoResultadoExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoResultadoExamenNombre resultadoExamenNombre;
    private Integer estado;
    public EstadoResultadoExamen(){super();}
    public EstadoResultadoExamen(@NotNull EstadoResultadoExamenNombre resultadoExamenNombre) {
        super();
        this.resultadoExamenNombre = resultadoExamenNombre;
        this.estado = 1;
        this.id = resultadoExamenNombre.ordinal()+1;
    }
}
