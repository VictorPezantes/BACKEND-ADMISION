package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.EstadoPostulanteNombre;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "estado_postulante")
public class EstadoPostulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPostulanteNombre estadoPostulanteNombre;
    private Integer estado;
    public EstadoPostulante(){super();}
    public EstadoPostulante(@NotNull EstadoPostulanteNombre estadoPostulanteNombre) {
        super();
        this.estadoPostulanteNombre = estadoPostulanteNombre;
        this.estado = 1;
        this.id = estadoPostulanteNombre.ordinal()+1;
    }
}
