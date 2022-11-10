package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.EstadoOfertaNombre;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Data
@Table(name = "estado_oferta")
public class EstadoOferta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoOfertaNombre estadoOfertaNombre;
    private Integer estado;
    public EstadoOferta(){super();}
    public EstadoOferta(@NotNull EstadoOfertaNombre estadoOfertaNombre) {
        super();
        this.estadoOfertaNombre = estadoOfertaNombre;
        this.estado = 1;
        this.id = estadoOfertaNombre.ordinal()+1;
    }
}

