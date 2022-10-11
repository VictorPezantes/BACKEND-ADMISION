package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.SubEstadoNombre;
import com.pe.ttk.admision.enums.TipoExamenNombre;
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
    public SubEstado(@NotNull SubEstadoNombre subEstadoNombre) {
        super();
        this.subEstadoNombre = subEstadoNombre;
        this.estado = 1;
        this.id = subEstadoNombre.ordinal()+1;
    }

    public SubEstado(){super();}
}
